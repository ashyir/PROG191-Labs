import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class ContactList {
    List<Contact> Contacts;

    public ContactList() {
        this.Contacts = new ArrayList<Contact>();
    }

    public void showAllByName() {
        System.out.println("All contact names:");

        for (Contact contact : Contacts) {
            System.out.println(contact.getName());
        }
    }

    public void addContact(String name, String phone) {
        Contact contact = new Contact(name, phone);
        this.Contacts.add(contact);
    }

    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);
        this.Contacts.add(contact);
    }

    public void addContact(String name, String phone, String email, String address) {
        Contact contact = new Contact(name, phone, email, address);
        this.Contacts.add(contact);
    }

    public void viewDetails(String name) {
        Contact contact = findContact(name);

        if (contact != null) {
            System.out.printf("\nDetails of %s:", contact.getName());
            System.out.printf("\nName: %s.", contact.getName());
            System.out.printf("\nPhone: %s.", contact.getPhone());
            System.out.printf("\nEmail: %s.", contact.getEmail());
            System.out.printf("\nAddress: %s.", contact.getAddress());
        } else {
            System.out.println("No contact found.");
        }
    }

    public Contact findContact(String name) {
        for (Contact contact : Contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }

        return null;
    }

    public void updateContact(String name, String phone) {
        Contact contact = findContact(name);
        contact.setPhone(phone);
    }

    public void deleteContact(String name) {
        Contact contact = findContact(name);

        Contacts.remove(contact);
    }
}