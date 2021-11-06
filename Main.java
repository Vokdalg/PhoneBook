import java.util.Scanner;

public class Main {
    public static String getTextValue(Scanner scanner, String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (Menu.printMenu(scanner)) {
                case "0":
                    return;
                case "1":
                    PhoneContacts.createGroup(scanner);
                    break;
                case "2":
                    Contact.createContact(scanner);
                    break;
                case "3":
                    PhoneContacts.printPhoneBook();
                    break;
                case "4":
                    for (Contact contact : PhoneContacts.getAllContacts()) {
                        System.out.println(contact);
                    }
                    break;
                default:
                    System.out.println("Некорректный вариант ввода!");
            }
        }
    }
}