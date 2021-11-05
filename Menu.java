import java.util.Scanner;

public class Menu {
    protected static String printMenu(Scanner scanner) {
        System.out.print("Программа телефонный справочник\n" +
                "1. Создать группу контактов\n" +
                "2. Создать контакт\n" +
                "3. Добавить контакт в группу\n" +
                "4. Вывести группу контактов\n" +
                "5. Вывести все контакты в отсортированном виде\n" +
                "0. Выход\n");
        return scanner.nextLine();
    }
}