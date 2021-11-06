import java.util.*;

public class PhoneContacts {
    private static final HashMap<String, ArrayList> PHONE_BOOK = new HashMap();

    public static List<Contact> getAllContacts() {
        return allContacts;
    }

    private static List<Contact> allContacts = new ArrayList<>();

    public static void addContactToList(Contact contact) {
        int position = Collections.binarySearch(allContacts, contact);
        if (position >= 0) {
            System.out.println("Контакт с указанными данными уже создан!");
        } else {
            allContacts.add(Math.abs(position) - 1, contact);
            System.out.println("Успешно создан контакт: " + contact);
        }
    }

    protected static HashMap<String, ArrayList> getPhoneBook() {
        return PHONE_BOOK;
    }

    protected static void addGroup(String groupName, ArrayList group) {
        PHONE_BOOK.put(groupName, group);
    }

    protected static void createGroup(Scanner scanner) {
        while (true) {
            String groupName = Main.getTextValue(scanner, "Введите название новой группы (или введите нет): ");
            if (!groupName.equals("нет") && !PhoneContacts.getPhoneBook().containsKey(groupName)) {
                PhoneContacts.addGroup(groupName, new ArrayList());
                System.out.println("Успешно создана группа: " + groupName);
            } else if (PhoneContacts.getPhoneBook().containsKey(groupName)) {
                System.out.println("Группа с таким именем уже существует!");
                break;
            } else {
                break;
            }
        }
    }

    protected static void printPhoneBook() {
        for (String groupName : getPhoneBook().keySet()) {
            System.out.println("Группа: " + groupName + "\n    Контакты: ");
            for (Object contact : getPhoneBook().get(groupName)) {
                System.out.println("      " + contact);
            }
        }
    }
}