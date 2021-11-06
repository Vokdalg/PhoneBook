import java.util.Scanner;

public class Main {
    public static String getTextValue(Scanner scanner, String question) {
        System.out.println(question);
        return scanner.nextLine();
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
                        PhoneContacts.createGroup(scanner);
                        break;
                    case 2:
                        Contact.createContact(scanner);
                        break;
                    case 3:
                        PhoneContacts.printPhoneBook();
                        break;
                    case 4:
                        PhoneContacts.deleteGroup(scanner);
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
}
