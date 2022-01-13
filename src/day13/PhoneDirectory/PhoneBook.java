package day13.PhoneDirectory;

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

    public List<Contact> addContact(Contact contact, GroupContacts groupContacts) {
        List<Contact> contactList = listContacts.get(groupContacts);
        if (contactList == null) {
            contactList = new LinkedList<>();
        }
        contactList.add(contact);
        setListContacts(groupContacts, contactList);
        return getListContacts(groupContacts);
    }
}
