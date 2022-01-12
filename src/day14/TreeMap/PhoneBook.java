package day14.TreeMap;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneBook extends Contact {
    private static final String ANSI_RED = "\u001B[41m"; // подцветка разницы доход - расход - красный фон
    private static final String ANSI_BLACK = "\u001b[30m"; // черный
    private static final String ANSI_SCARLET = "\u001b[31m"; // алый
    private static final String ANSI_GREEN = "\u001b[32m"; // зеленый
    private static final String ANSI_YELLOW = "\u001b[33m"; // Жёлтый
    private static final String ANSI_BLUE = "\u001b[34m"; // Синий
    private static final String PURPLE = "\u001b[35m"; // Пурпурный
    private static final String ANSI_CYAN = "\u001b[36m"; // Голубой
    private static final String ANSI_WHITE = "\u001b[37m"; // Белый
    private static final String ANSI_RESET = "\u001B[0m"; // конец подцветки - черный фон


    HashMap<GroupContacts, List<Contact>> listContacts = new HashMap<GroupContacts, List<Contact>>();

    public PhoneBook() {
    }

    public List<Contact> getListContacts(GroupContacts group) {
        return listContacts.get(group);
    }


    public void setListContacts(HashMap<GroupContacts, List<Contact>> listContacts) {
        this.listContacts = listContacts;
    }

    public void setListContacts(GroupContacts group, List<Contact> contactList) {
        this.listContacts.put(group, contactList);
    }

    @Override
    public String toString() {

        return "PhoneBook{" +
                "listContacts=" + listContacts +
                '}';
    }

    public void findContactsGroup(GroupContacts group) {
        System.out.println(listContacts.get(group));
    }

    public GroupContacts addGroup(String group) {
        return new GroupContacts(group);
    }

    public void delContact(GroupContacts groupContacts, Contact contact) {
        List<Contact> contactList = getContactsList(groupContacts);
        if (contactList.contains(contact)) {
            contactList.remove(contactList.indexOf(contact));//удаляем по индексу найденного элемента
        } else {
            System.out.printf("%s отсутствует. %sУдаление невозможно из %s%s\n", contact, ANSI_BLUE, groupContacts, ANSI_RESET);
        }
        ;
    }

    public List<Contact> addContact(Contact contact, GroupContacts groupContacts) {
        List<Contact> contactList = getContactsList(groupContacts);
        contactList.add(contact);
        setListContacts(groupContacts, contactList);
        return getListContacts(groupContacts);
    }

    public void consolPhoneBookGroup(GroupContacts group) {
        for (Map.Entry entry : listContacts.entrySet()) {
            if (entry.getKey().equals(group)) {
                System.out.println(entry);
            }
        }
    }

    @NotNull
    private List<Contact> getContactsList(GroupContacts groupContacts) {
        List<Contact> contactList = listContacts.get(groupContacts);
        if (contactList == null) {
            contactList = new LinkedList<>();
        }
        return contactList;
    }

    public Object searchContact(GroupContacts group, Contact contact) {
        for (Map.Entry entry : listContacts.entrySet()) {
            if (entry.getKey().equals(group)) { // выделяем группу поиска
                LinkedList list = (LinkedList) entry.getValue();
                for (Object li : list) {
                    if (li.equals(contact)) {
                        System.out.printf("В группе : %s Найден контакт: %s \n", group, li);
                        return li; //выходим сразу как нашли одно совпадение
                    }
                }
            }
        }
        System.out.printf("В группе : %s нет пользователя %s\n", group, contact);
        return null;
    }

    public Object searchContact(String phone) {
        LinkedList listnew = new LinkedList<>();
        System.out.printf("\nПоиск контакта по номеру телефона: %s ->>", phone);
        boolean flag = false;
        for (Map.Entry entry : listContacts.entrySet()) {

            LinkedList list = (LinkedList) entry.getValue();
            for (Object li : list) {
                if (String.valueOf(li).contains(phone)) {
                    System.out.printf("\nНайден контакт: %s \n", li);
                    listnew.add(li);
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.printf("  %sконтакт по номеру телефона %s не найден%s\n", ANSI_YELLOW, phone, ANSI_RESET);
        }
        return listnew;
    }
}
