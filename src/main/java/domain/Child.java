package domain;

public class Child {
    /*
    * 12. Детский сад.
Вести учет детей в детском саду.
Ребенок: ФИО, пол, возраст.
Группа: название, номер.
- добавлять/удалять группу и детей в них.
- редактировать группы/детей.
Выводить информацию по группам (группа, дети в ней).
* */
    private int id;
    private String firstName;
    private String lastName;        //fio
    private String patronymic;
    private Gender gender;
    private int age;//
    private int groupId;

    public Child() {
    }

    public Child(String firstName, String lastName, String patronymic, Gender gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.age = age;
    }

    public Child(String firstName, String lastName, Gender gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.gender = gender;
        this.age = age;
    }

    public Child(String firstName, String lastName, String patronymic, Gender gender, int age, int groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.age = age;
        this.groupId = groupId;
    }
    public Child(String firstName, String lastName, Gender gender, int age, int groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.groupId = groupId;
    }

    public Child(int id, String firstName, String lastName, String patronymic, String gender, int age, int groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.gender = Gender.valueOf(gender);
        this.age = age;
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
