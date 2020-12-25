package dao;

import domain.Child;
import domain.Gender;
import domain.Group;

import java.util.ArrayList;
import java.util.List;

public class SingletonListGroups {
    private static SingletonListGroups INSTANCE;
    private List<Group> groups= new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    private SingletonListGroups() {
//        Group g1 = new Group(1, "my kids");
//
//        groups.add(g1);
//
//        List<Child> deti = new ArrayList();
//        deti.add(new Child("Masha",
//                "Antonova",
//                "Pavlovna",
//                Gender.WARHELICOPTER,
//                5));
//        deti.add(new Child("Slava",
//                "Slavovenko",
//                "Pavlovich",
//                Gender.WARHELICOPTER,
//                6));
//        deti.add(new Child("Valeriy",
//                "Zhmishenko",
//                "Albertovich",
//                Gender.MALE,
//                7));



    }

    public static SingletonListGroups getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonListGroups();
        }
        return INSTANCE;
    }
}
