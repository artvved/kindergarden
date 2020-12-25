package ui;

import domain.Child;
import domain.Gender;
import domain.Group;

import java.util.List;
import java.util.Map;

public class Printer {
    public void printText(String text) {
        System.out.println(text);
    }

    public void requestFromUserSmth(String smth) {
        System.out.printf("Enter %s\n", smth);
    }

    public void requestFromUserSmthOfSmb(String smth, String smb) {
        System.out.printf("Enter %s of the %s\n", smth, smb);
    }

    public void printGroupInfo(Map<String, String> groupParams) {
        String groupId = groupParams.get("groupId");
        String number = groupParams.get("number");
        String name = groupParams.get("name");

        StringBuilder sb = new StringBuilder();
        sb.append("groupId - ").append(groupId).append("\n");
        sb.append("number - ").append(number).append("\n");
        sb.append("name - ").append(name).append("\n");
        System.out.println(sb.toString());

    }

    public void printGroupInfo(Map<String, String> groupParams, List<Map<String, String>> childrenParams) {
        printGroupInfo(groupParams);

        if (!childrenParams.isEmpty()) {
            System.out.println("children: ");
            for (Map<String, String> params : childrenParams) {
                printChildInfo(params);
            }
        }else System.out.println("no children so far");
    }

    public void printChildInfo(Map<String, String> map) {
        String childId = map.get("childId");
        String firstName = map.get("firstName");
        String lastName = map.get("lastName");
        String patronymic = map.get("patronymic");
        String age = map.get("age");
        String gender = map.get("gender");
        String groupId = map.get("groupId");

        StringBuilder sb = new StringBuilder();
        sb.append("childId - ").append(childId).append("\n");
        sb.append("firstName - ").append(firstName).append("\n");
        sb.append("lastName - ").append(lastName).append("\n");
        sb.append("patronymic - ").append(patronymic).append("\n");
        sb.append("age - ").append(age).append("\n");
        sb.append("gender - ").append(gender).append("\n");
        sb.append("groupId - ").append(groupId).append("\n");
        System.out.println(sb.toString());
    }

    public void printGeneralCommands() {
        System.out.println("Choose what you want to do");

        System.out.println("1 - add group");
        System.out.println("2 - remove group");
        System.out.println("3 - look at group closer");
        System.out.println("0 - finish work");
    }

    public void printGroupCommands() {
        System.out.println("4 - print group and children");
        System.out.println("5 - rename");
        System.out.println("6 - change number");
        System.out.println("7 - add child");
        System.out.println("8 - remove child");
        System.out.println("9 - look at child closer");
    }

    public void printChildCommands() {
        System.out.println("10 - change first name");
        System.out.println("11 - change second name");
        System.out.println("12 - change patronymic");
        System.out.println("13 - change gender");
        System.out.println("14 - change age");
        System.out.println("15 - change group id");
        System.out.println("16 - print child info");

    }

}
