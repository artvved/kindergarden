package domain;



public class Group {
    private int id;
    private int groupNumber;
    private String groupName;

    public Group() {
    }

    public Group(int id, int groupNumber, String groupName) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.groupName = groupName;
    }

    public Group(int groupNumber, String groupName) {
        this.groupNumber = groupNumber;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
