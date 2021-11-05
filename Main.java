import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static String getTextValue(Scanner scanner, String question) {
        System.out.println(question);
        String result = scanner.nextLine();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int usersChoice = Integer.parseInt(Menu.printMenu(scanner));
                switch (usersChoice) {
                    case 0:
                        return;
                    case 1:
                        while (true) {
                            String groupName = getTextValue(scanner, "Введите название новой группы (или введите нет): ");
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
                        break;
                    case 2:
                        String contactName = getTextValue(scanner, "Введите наименование контакта или введите нет: ");
                        if (!contactName.equals("нет")) {
                            String contactNumber = getTextValue(scanner, "Введите номер контакта или введите нет: ");
                            if (!contactNumber.equals("нет")) {
                                Contact contact = new Contact(contactName, contactNumber);
                                System.out.println("Успешно создан контакт: " + contactName);
                                String inputGroupName = getTextValue(scanner, "Для того, чтобы сохранить контакт, введите группы через пробел, куда вы хотите поместить контакт или введите нет: ");
                                if (!inputGroupName.equals("нет")) {
                                    String[] groups = inputGroupName.split(" ");
                                    for (String group : groups) {
                                        if (PhoneContacts.getPhoneBook().containsKey(group)) {
                                            PhoneContacts.getPhoneBook().get(group).add(contact);
                                        }
                                    }
                                }
                            }
                        } else {
                            break;
                        }
                        break;
                    case 3:
//                        break;
                    case 4:
                        System.out.println(PhoneContacts.getPhoneBook().toString());
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Некорректный вариант ввода!");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Необходимо ввести номер пункта меню.");
                continue;
            }
        }
    }
//        PhoneContacts.addGroup("Родня", PhoneContacts.getRelatives());
//        PhoneContacts.addGroup("Друзья", PhoneContacts.getFriends());
//        PhoneContacts.addGroup("Коллеги", PhoneContacts.getCoworkers());
//        System.out.println(PhoneContacts.getPhoneBook().toString());
//        Contact contact1 = new Contact("Oleg Gladkov", "+79319999999");
//        Contact contact2 = new Contact("Yana Gladkova", "+79318888888");
//        Contact contact3 = new Contact("Elena Gladkova", "+79317777777");
//        PhoneContacts.addContactToGroup(contact1, PhoneContacts.getRelatives());
//        PhoneContacts.addContactToGroup(contact2, PhoneContacts.getFriends());
//        PhoneContacts.addContactToGroup(contact3, PhoneContacts.getCoworkers());
//        System.out.println(PhoneContacts.getPhoneBook().toString());
//        Contact contact4 = new Contact("Oleg Gladkov", "+79319999999");
//        PhoneContacts.addContactToGroup(contact4, PhoneContacts.getRelatives());
//        System.out.println(PhoneContacts.getPhoneBook().toString());
}
