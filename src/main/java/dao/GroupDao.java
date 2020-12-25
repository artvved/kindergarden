package dao;

import domain.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDao implements Dao<Group> {

    private Connection connection;


    public GroupDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Group get(int id) {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT id, name,number FROM group WHERE id  = " + id)) {
                while (rs.next()) {
                    return new Group(rs.getInt("id"),
                            rs.getInt("number"),
                            rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Record with id " + id + "not found");
    }

    @Override
    public List<Group> getAll() {
        final List<Group> result = new ArrayList<>();

        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT id, name,number FROM group")) {
                while (rs.next()) {
                    result.add(new Group(rs.getInt("id"),
                            rs.getInt("number"),
                            rs.getString("name"))
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public void add(Group model) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO group(name,number) VALUES(?,?)")
        ){
            preparedStatement.setString(1,model.getGroupName());
            preparedStatement.setInt(2,model.getGroupNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, Group model) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE group SET name = ? , number = ? WHERE id = ?"
        )) {
            int count = 1;
            if ( model.getGroupName()!=null)
            preparedStatement.setString(count, model.getGroupName());
            count++;
            if ( model.getGroupNumber()!=0)
            preparedStatement.setInt(count, model.getGroupNumber());
            count++;
            preparedStatement.setInt(count, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM group WHERE id = ?")
        ) {
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 0) {
                throw new IllegalStateException("Record with id = " + id + " not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Group getByName(String name){
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT id FROM group WHERE name  = '" + name + "'")) {
                while (rs.next()) {
                    Group group = new Group();
                    group.setGroupName(name);
                    group.setId(rs.getInt("id"));
                    return group;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Record with name " + name + "not found");
    }


    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}