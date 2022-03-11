package day14.TreeMap;

public class Contact {
    String name; //имя
    String phoneNumber; // номер телефона

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        return new Contact(this.name = name, "");
    }

    public Contact setName(String name, String phoneNumber) {
        return new Contact(this.name = name, this.phoneNumber = phoneNumber);
    }
/*
    public String getPhoneNumber() {
        return this.phoneNumber;
    }*/

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\n\t\tКонтакт {" + "имя='" + name + '\'' + ", телефон='" + phoneNumber + '\'' + "}";
    }

}
