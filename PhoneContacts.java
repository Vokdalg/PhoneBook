import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneContacts {
    private static HashMap<String, ArrayList> phoneBook = new HashMap();

    protected static HashMap<String, ArrayList> getPhoneBook() {
        return phoneBook;
    }

    protected static void addGroup (String groupName, ArrayList group) {
        phoneBook.put(groupName, group);
    }

    protected static void addContactToGroup (Contact contact, ArrayList group) {
        group.add(contact);
    }

    protected static void createGroup (Scanner scanner) {
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

    public static void deleteGroup(Scanner scanner) {
        while (true) {
            System.out.println("ВНИМАНИЕ! Группа будет удалена, а контакты в ней безвозвратно потеряны!");
            String groupName = Main.getTextValue(scanner, "Введите название группы, которую хотите удалить (или введите нет): ");
            if (!groupName.equals("нет") && PhoneContacts.getPhoneBook().containsKey(groupName)) {
                PhoneContacts.getPhoneBook().remove(groupName);
                System.out.println("Успешно удалена группа: " + groupName);
            } else if (!PhoneContacts.getPhoneBook().containsKey(groupName)) {
                System.out.println("Группы с таким именем не существует!");
                break;
            } else {
                break;
            }
        }
    }
}
