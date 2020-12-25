import bl.DomainChecksLogic;
import service.ChildService;
import service.GroupService;
import ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        DomainChecksLogic bl = new DomainChecksLogic();
        ChildService childService=new ChildService();
        GroupService groupService = new GroupService();

        ConsoleUI cui = new ConsoleUI(groupService,childService);

        cui.start();



    }
}
