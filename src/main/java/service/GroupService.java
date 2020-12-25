package service;

import connection.ConnectionUtils;
import dao.ChildDao;
import dao.GroupDao;
import domain.Child;
import domain.Group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService {
    private GroupDao groupDao;
    private int id;

    public GroupService() {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            groupDao = new GroupDao(connection);
            id = groupDao.getAll().get(groupDao.getAll().size()-1).getId();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Group get(int id) {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {

            groupDao.setConnection(connection);
            return groupDao.get(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Group> getAll() {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            groupDao.setConnection(connection);
            return groupDao.getAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void save(Group group) {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            groupDao.setConnection(connection);
            if (group.getId() <= this.id & group.getId() != 0){
                groupDao.update(group.getId(), group);
            } else if (group.getId() == 0){
                this.id++;
                group.setId(this.id);
                groupDao.add(group);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            groupDao.setConnection(connection);
            groupDao.delete(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Group getByName(String name){
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            groupDao.setConnection(connection);
            return groupDao.getByName(name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Map<String, String> getGroupParams(int groupId) {
        Group group = groupDao.get(groupId);
        Map<String, String> map = new HashMap<>();

        map.put("groupId", String.valueOf(group.getId()));
        map.put("number", String.valueOf(group.getGroupNumber()));
        map.put("name", group.getGroupName());

        return map;
    }

}

