import java.util.ArrayList;
import java.util.HashMap;

public class PhoneContacts {
    private static HashMap<String, ArrayList> phoneBook = new HashMap();

    public static HashMap<String, ArrayList> getPhoneBook() {
        return phoneBook;
    }

    public static void addGroup (String groupName, ArrayList group) {
        phoneBook.put(groupName, group);
    }

    public static void addContactToGroup (Contact contact, ArrayList group) {
        group.add(contact);
    }
}
