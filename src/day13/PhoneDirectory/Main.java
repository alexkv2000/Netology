package day13.PhoneDirectory;

public class Main {
    public static void main(String[] args) {

        //Создадим класс Contact c полями: имя и номер телефона (при необходимости переоределим hashCode, equals, toString).
        //Создадим методы для добавления группы и контакта в группы в классе PhoneBook.
        //Для демонстрации работы программы в коде создадим несколько контактов и добавим их в несколько групп.

        PhoneBook phoneBook = new PhoneBook();

        Contact Jhon = phoneBook.setName("Jhon", "+79601888888");
        Contact Jgarge = phoneBook.setName("Jarge", "+79601777777");
        Contact Ruta = phoneBook.setName("Ruta", "+79601111111");
        Contact Alex = phoneBook.setName("Alex", "+79601111199");
        Contact Adam = phoneBook.setName("Adam", "+79601555555");
        Contact Valery = phoneBook.setName("Valery");
        Valery.setPhoneNumber("+79991222222");

        GroupContacts allGroup = phoneBook.addGroup("All");
        GroupContacts myGroup = phoneBook.addGroup("My");
        GroupContacts otherGroup = phoneBook.addGroup("Other");
        GroupContacts adminGroup = phoneBook.addGroup("Admin");

        phoneBook.addContact(Ruta, allGroup);
        phoneBook.addContact(Jgarge, allGroup);
        phoneBook.addContact(Alex, allGroup);
        phoneBook.addContact(Adam, allGroup);
        phoneBook.addContact(Valery, allGroup);
        phoneBook.addContact(Jhon, allGroup);

        phoneBook.addContact(Ruta, myGroup);
        phoneBook.addContact(Alex, myGroup);

        phoneBook.addContact(Alex, adminGroup);

        phoneBook.addContact(Valery, otherGroup);
        phoneBook.addContact(Adam, otherGroup);
        phoneBook.addContact(Jhon, otherGroup);

        //    отобразить список групп
        System.out.println("*            отобразить список групп              *");
        System.out.println("***************************************************");
        phoneBook.consolPhoneBookGroup(myGroup);
        phoneBook.consolPhoneBookGroup(allGroup);
        phoneBook.consolPhoneBookGroup(otherGroup);
        phoneBook.consolPhoneBookGroup(adminGroup);
        //--------------------
        //поиск контакта в группе
        System.out.println("*           поиск контакта в группе               *");
        System.out.println("***************************************************");
        phoneBook.searchContact(myGroup, Alex);
        phoneBook.searchContact(myGroup, Alex);

        //поиск Контакта по номеру телефона
        System.out.println("*       поиск Контакта по номеру телефона         *");
        System.out.println("***************************************************");
        phoneBook.searchContact("+796011111");

        System.out.println("*             удалить контакт из группы            *");
        System.out.println("***************************************************");

        phoneBook.consolPhoneBookGroup(otherGroup);
        phoneBook.delContact(otherGroup, Alex);
        phoneBook.delContact(otherGroup, Valery);
        phoneBook.consolPhoneBookGroup(otherGroup);
    }

}
