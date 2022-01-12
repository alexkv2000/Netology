package day14.TreeMap;

public class GroupContacts {
    String name;

    public GroupContacts(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Группа {" +
                "'" + name + '\'' +
                "}";
    }
}
