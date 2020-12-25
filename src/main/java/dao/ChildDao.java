package dao;

import domain.Child;
import domain.Gender;
import domain.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ChildDao implements Dao<Child> {

    private Connection connection;


    public ChildDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Child get(int id) {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT id, firstname,lastname,patronymic,gender,age,id_group FROM child WHERE id  = " + id)) {
                while (rs.next()) {
                    return new Child(rs.getInt("id"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("patronymic"),
                            rs.getString("gender"),
                            rs.getInt("age"),
                            rs.getInt("id_group")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Record with id " + id + "not found");
    }

    @Override
    public List<Child> getAll() {
        final List<Child> result = new ArrayList<>();

        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT id, firstname,lastname,patronymic,gender,age,id_group FROM child")) {
                while (rs.next()) {
                    result.add(new Child(rs.getInt("id"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("patronymic"),
                            rs.getString("gender"),
                            rs.getInt("age"),
                            rs.getInt("id_group")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public void add(Child model) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO child(firstname,lastname,patronymic,gender,age,id_group) VALUES(?,?,?,?,?,?)")
        ) {
            int count = 1;
            preparedStatement.setString(count++, model.getFirstName());
            preparedStatement.setString(count++, model.getLastName());
            preparedStatement.setString(count++, model.getPatronymic());
            preparedStatement.setString(count++, String.valueOf(model.getGender()));
            preparedStatement.setInt(count++, model.getAge());
            preparedStatement.setInt(count, model.getGroupId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, Child model) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE child SET firstname = ?, lastname = ?, patronymic = ?, gender = ?, age = ?, id_group = ? WHERE id = ?"
        )) {

            int count = 1;
            if (model.getFirstName() != null)
                preparedStatement.setString(count, model.getFirstName());
            count++;
            if (model.getLastName() != null)
                preparedStatement.setString(count, model.getLastName());
            count++;
            if (model.getPatronymic() != null)
                preparedStatement.setString(count, model.getPatronymic());
            count++;
            if (model.getGender() != null)
                preparedStatement.setString(count, String.valueOf(model.getGender()));
            count++;
            if (model.getAge() != 0)
                preparedStatement.setInt(count, model.getAge());
            count++;
            if (model.getGroupId() != 0)
                preparedStatement.setInt(count, model.getGroupId());
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
                "DELETE FROM child WHERE id = ?")
        ) {
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 0) {
                throw new IllegalStateException("Record with id = " + id + " not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Child getByLastName(String lastName) {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT id, firstName,lastName,patronymic,gender,age,id_group FROM child WHERE lastname  = '" + lastName + "'")) {
                while (rs.next()) {
                    return new Child(rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("patronymic"),
                            rs.getString("gender"),
                            rs.getInt("age"),
                            rs.getInt("id_group"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Record with name " + lastName + "not found");
    }


    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

