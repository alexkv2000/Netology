package day13.PhoneDirectory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Создадим класс Contact c полями: имя и номер телефона (при необходимости переоределим hashCode, equals, toString).
        //Создадим методы для добавления группы и контакта в группы в классе PhoneBook.
        //Для демонстрации работы программы в коде создадим несколько контактов и добавим их в несколько групп.

        PhoneBook phoneBook = new PhoneBook();

        Contact Jhon = phoneBook.setName("Jhon", "+79601888888");
        Contact Jgarge = phoneBook.setName("Jarge", "+79601777777");
        Contact Ruta = phoneBook.setName("Ruta", "+79601111111");
        Contact Alex = phoneBook.setName("Alex", "+79601999999");
        Contact Adam = phoneBook.setName("Adam", "+79601555555");
        Contact Valery = phoneBook.setName("Valery");
        Valery.setPhoneNumber("+79991222222");


        GroupContacts allGroup = phoneBook.addGroup("All");
        GroupContacts myGroup = phoneBook.addGroup("My");
        GroupContacts otherGroup = phoneBook.addGroup("Other");
        GroupContacts adminGroup = phoneBook.addGroup("Admin");

        List<Contact> contactListAll = new LinkedList<Contact>();
        contactListAll.add(Jhon);
        contactListAll.add(Jgarge);
        contactListAll.add(0, Ruta);
        contactListAll.add(1, Alex);
        contactListAll.add(Adam);

        List<Contact> contactListMy = new LinkedList<Contact>();
        contactListMy.add(Ruta);
        contactListMy.add(Alex);

        List<Contact> contactListOther = new LinkedList<Contact>();
        phoneBook.addContact(Adam, otherGroup);

        LinkedList contactListAdmin = new LinkedList<>();
        phoneBook.addContact(Valery, adminGroup);
        phoneBook.addContact(Valery, allGroup);
        phoneBook.addContact(Alex, adminGroup);

        phoneBook.setListContacts(myGroup, contactListMy);
        phoneBook.setListContacts(allGroup, contactListAll);
        phoneBook.setListContacts(otherGroup, contactListOther);


        //    отобразить List
        consolPhone(phoneBook, myGroup);
        consolPhone(phoneBook, allGroup);
        consolPhone(phoneBook, otherGroup);
        consolPhone(phoneBook, adminGroup);
        //--------------------
        //TODO поиск Контакта по номеру телефона

    }


    private static void consolPhone(PhoneBook phoneBook, GroupContacts group) {
        for (Map.Entry entry : phoneBook.listContacts.entrySet()) {
            if (entry.getKey().equals(group)) {
                System.out.println(entry);
            }
        }
    }
}
