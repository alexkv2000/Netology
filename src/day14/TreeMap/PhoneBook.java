package day14.TreeMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static day14.TreeMap.AnsiColor.*;

public class PhoneBook extends Contact {

    HashMap<GroupContacts, List<Contact>> listContacts = new HashMap<>();

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
            System.out.printf("%s %sотсутствует. Удаление невозможно из %s%s\n", contact, ANSI_BLUE, groupContacts.toString().replaceAll("\n", ""), ANSI_RESET);
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

    public LinkedList searchContact(String phone, boolean visible) {
        LinkedList listnew = new LinkedList<>();
//        System.out.printf("\nПоиск контакта по номеру телефона: %s ->>", phone);
        boolean flag = false;
        for (Map.Entry entry : listContacts.entrySet()) {

            LinkedList list = (LinkedList) entry.getValue();
            for (Object li : list) {
                if (String.valueOf(li).contains(phone)) {
                    if (visible) {
                        System.out.printf("%s%s найден%s\n", ANSI_GREEN, li.toString().replaceAll("\n", "").replaceAll("\t", ""), ANSI_RESET);
                    }
                    //TODO проверить на наличие в списке, если есть НЕ добавляем повторные
                    listnew.add(li);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            if (visible) {
                System.out.printf("%sконтакт по номеру телефона %s не найден%s\n", ANSI_YELLOW, phone, ANSI_RESET);
            }
        }
        return listnew;
    }
}
