package service;


import connection.ConnectionUtils;
import dao.ChildDao;
import domain.Child;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChildService {
    private ChildDao childDao;
    private int id;

    public ChildService() {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            childDao = new ChildDao(connection);
            id = childDao.getAll().get(childDao.getAll().size()-1).getId();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Child get(int id) {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            childDao.setConnection(connection);
            return childDao.get(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Child> getAll() {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            childDao.setConnection(connection);
            return childDao.getAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void save(Child child) {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            childDao.setConnection(connection);
            if (child.getId() <= this.id & child.getId() != 0){
                childDao.update(child.getId(), child);
            } else if (child.getId() == 0){
                this.id++;
                child.setId(this.id);
                childDao.add(child);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            childDao.setConnection(connection);
            childDao.delete(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Child getByName(String name){
        try (Connection connection = DriverManager.getConnection(ConnectionUtils.URL,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD)
        ) {
            childDao.setConnection(connection);
            return childDao.getByLastName(name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Map<String,String> getChildParams(int childId){
        Child child=childDao.get(childId);
        Map<String,String> map=new HashMap<>();
        map.put("childId", String.valueOf(child.getId()));
        map.put("firstName",child.getFirstName());
        map.put("lastName",child.getLastName());
        map.put("patronymic",child.getPatronymic());
        map.put("age",String.valueOf(child.getAge()));
        map.put("gender",String.valueOf(child.getGender()));
        map.put("groupId",String.valueOf(child.getGroupId()));
        return map;
    }
    public List<Map<String, String>> getGroupChildrenParams(int groupId) {
        List<Map<String, String>> list=new ArrayList<>();
        List<Child> children=childDao.getAll();
        for (Child child:children){
            if (child.getGroupId()==groupId)
                list.add(getChildParams(child.getId()));
        }

        return list;
    }

}


