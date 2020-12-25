package dao;

import domain.Child;
import domain.Group;

import java.util.ArrayList;
import java.util.List;

public class SingletonListChildren {
    private static SingletonListChildren INSTANCE;
    private List<Child> children= new ArrayList<>();

    public List<Child> getGroups() {
        return children;
    }

    private SingletonListChildren() {

    }

    public static SingletonListChildren getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonListChildren();
        }
        return INSTANCE;
    }
}
