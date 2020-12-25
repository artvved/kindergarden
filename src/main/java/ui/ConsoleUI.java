package ui;

import domain.Child;
import domain.Gender;
import domain.Group;
import service.ChildService;
import service.GroupService;

import java.util.Scanner;

public class ConsoleUI {
    private Printer printer = new Printer();

    private GroupService groupChanger;
    private ChildService childChanger;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleUI(GroupService groupChanger, ChildService childChanger) {
        this.groupChanger = groupChanger;
        this.childChanger = childChanger;
    }

    private void addGroup() {
        printer.requestFromUserSmthOfSmb("name", "group");
        String name = scanner.nextLine();
        printer.requestFromUserSmthOfSmb("number", "group");
        int number = scanner.nextInt();
        groupChanger.save(new Group(number, name));
    }

    private void removeGroup() {
        printer.requestFromUserSmthOfSmb("id", "group");
        int id = scanner.nextInt();
        groupChanger.delete(id);
    }

    private void renameGroup(int id) {
        printer.requestFromUserSmth("new name");
        String rename = scanner.nextLine();
        Group g=new Group();
        g.setId(id);
        g.setGroupName(rename);
        groupChanger.save(g);

    }

    private void changeGroupNumber(int id) {
        printer.requestFromUserSmth("new number");
        int renumber = scanner.nextInt();
        Group g=new Group();
        g.setId(id);
        g.setGroupNumber(renumber);
        groupChanger.save(g);
    }


    private void addChildToGroup(int groupId) {
        printer.requestFromUserSmthOfSmb("first name", "child");
        String firstName = scanner.nextLine();
        System.out.println(firstName + 1);
        printer.requestFromUserSmthOfSmb("last name", "child");
        String lastName = scanner.nextLine();
        printer.requestFromUserSmthOfSmb("patronymic", "child");
        printer.printText("or print null");
        String patronymic = scanner.nextLine();
        if (patronymic.trim().equals("null"))
            patronymic = null;
        printer.requestFromUserSmthOfSmb("gender", "child");
        String gender = scanner.nextLine();
        printer.requestFromUserSmthOfSmb("age", "child");
        int age = scanner.nextInt();
        Child c=new Child(firstName, lastName, patronymic, Gender.valueOf(gender), age, groupId);
        childChanger.save(c);


    }

    private void removeChildFromGroup() {
        printer.requestFromUserSmthOfSmb("id", "child");
        int childId = scanner.nextInt();
        Child c=new Child();
        c.setId(childId);
        childChanger.save(c);
    }


    private void changeGroup() {
        printer.requestFromUserSmthOfSmb("id", "group");
        int groupId = scanner.nextInt();

            printer.printText("group found, choose what you want to do with it");
            printer.printGroupCommands();

            int action = getActionFromConsole();

            switch (action) {
                case (4):
                    printer.printGroupInfo(groupChanger.getGroupParams(groupId),
                            childChanger.getGroupChildrenParams(groupId));
                    break;
                case (5):
                    renameGroup(groupId);
                    break;
                case (6):
                    changeGroupNumber(groupId);
                    break;
                case (7):
                    addChildToGroup(groupId);
                    break;
                case (8):
                    removeChildFromGroup();
                    break;
                case (9):
                    changeChild();
                    break;
                default:
                    printer.printText("no such option");
                    break;
            }


    }

    private void changeChildFirstName(int childId) {
        printer.requestFromUserSmthOfSmb("first name", "child");
        String firstName = scanner.nextLine();
        Child c=new Child();
        c.setId(childId);
        c.setFirstName(firstName);
        childChanger.save(c);
    }

    private void changeChildLastName(int childId) {
        printer.requestFromUserSmthOfSmb("last name", "child");
        String lastName = scanner.nextLine();
        Child c=new Child();
        c.setId(childId);
        c.setLastName(lastName);
        childChanger.save(c);
    }

    private void changeChildPatronymic(int childId) {
        printer.requestFromUserSmthOfSmb("patronymic", "child");
        String patronymic = scanner.nextLine();
        Child c=new Child();
        c.setId(childId);
        c.setPatronymic(patronymic);
        childChanger.save(c);
    }

    private void changeChildGender(int childId) {
        printer.requestFromUserSmthOfSmb("gender", "child");
        String gender = scanner.nextLine();
        Child c=new Child();
        c.setId(childId);
        c.setGender(Gender.valueOf(gender));
        childChanger.save(c);
    }

    private void changeChildAge(int childId) {
        printer.requestFromUserSmthOfSmb("gender", "child");
        int age = Integer.parseInt(scanner.nextLine());
        Child c=new Child();
        c.setId(childId);
        c.setAge(age);
        childChanger.save(c);
    }

    private void changeChildGroupId(int childId) {
        printer.requestFromUserSmthOfSmb("group id", "child");
        int groupId = Integer.parseInt(scanner.nextLine());
        Child c=new Child();
        c.setId(childId);
        c.setGroupId(groupId);
        childChanger.save(c);
    }

    private void changeChild() {

        printer.requestFromUserSmthOfSmb("id", "child");
        int childId = scanner.nextInt();


            printer.printText("child found, choose what you want to do with it");
            printer.printChildCommands();

            int action = getActionFromConsole();

            switch (action) {
                case (10):
                    changeChildFirstName(childId);
                    break;
                case (11):
                    changeChildLastName(childId);
                    break;
                case (12):
                    changeChildPatronymic(childId);
                    break;
                case (13):
                    changeChildGender(childId);
                    break;
                case (14):
                    changeChildAge(childId);
                    break;
                case (15):
                    changeChildGroupId(childId);
                    break;
                case (16):
                    printer.printChildInfo(childChanger.getChildParams(childId));
                    break;
                default:
                    printer.printText("no such option");
                    break;
            }

    }

    public void start() {

        while (true){
            printer.printGeneralCommands();

            int action = getActionFromConsole();

            switch (action) {
                case (0):
                    return;
                case (1):
                    addGroup();
                    break;
                case (2):
                    removeGroup();
                    break;
                case (3):
                    changeGroup();
                    break;
                default:
                    printer.printText("no such option");
                    break;
            }


        }

    }

    private int getActionFromConsole() {
        int action = scanner.nextInt();
        scanner.nextLine();
        return action;
    }

}
