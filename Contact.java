import java.util.Objects;
import java.util.Scanner;

public class Contact implements Comparable<Contact> {
    private final String NAME;
    private final String PHONE_NUMBER;

    public Contact(String NAME, String PHONE_NUMBER) {
        this.NAME = NAME;
        this.PHONE_NUMBER = PHONE_NUMBER;
        PhoneContacts.addContactToList(this);
    }

    protected static void createContact(Scanner scanner) {
        String contactName = Main.getTextValue(scanner, "Введите наименование контакта или введите нет: ");
        if (!contactName.equals("нет")) {
            String contactNumber = Main.getTextValue(scanner, "Введите номер контакта или введите нет: ");
            if (!contactNumber.equals("нет")) {
                Contact contact = new Contact(contactName, contactNumber);
                String inputGroupName = Main.getTextValue(scanner, "Введите группы через пробел, куда вы хотите поместить контакт или введите нет: ");
                if (!inputGroupName.equals("нет")) {
                    String[] groups = inputGroupName.split(" ");
                    for (String group : groups) {
                        try {
                            if (PhoneContacts.getPhoneBook().containsKey(group) && !PhoneContacts.getPhoneBook().get(group).contains(contact)) {
                                PhoneContacts.getPhoneBook().get(group).add(contact);
                                System.out.println("Контакт " + contactName + " успешно добавлен в группу " + group);
                            } else if (PhoneContacts.getPhoneBook().get(group).contains(contact)) {
                                System.out.println("Контакт " + contactName + " с номером телефона " + contactNumber + " уже содержится в группе " + group);
                            }
                        } catch (NullPointerException exception) {
                            System.out.println("Не существует группы: " + group);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Контакт: " + NAME + " Телефон: " + PHONE_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return NAME.equals(contact.NAME) && PHONE_NUMBER.equals(contact.PHONE_NUMBER);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, PHONE_NUMBER);
    }

    @Override
    public int compareTo(Contact contact) {
        return this.NAME.compareTo(contact.NAME);
    }
}