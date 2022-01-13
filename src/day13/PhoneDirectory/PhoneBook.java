package day13.PhoneDirectory;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PhoneBook extends Contact {

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
            System.out.printf("%s нет в %s. Удаление невозможно.\n\n",contact, groupContacts);
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
            System.out.printf(" контакт по номеру телефона %s не найден\n", phone);
        }
        return listnew;
    }
}
