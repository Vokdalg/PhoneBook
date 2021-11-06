import java.util.Scanner;

public class Menu {
    protected static String printMenu(Scanner scanner) {
        System.out.print("Программа телефонный справочник\n" +
                "1. Создать группу контактов\n" +
                "2. Создать контакт\n" +
                "3. Вывести группы с контактами\n" +
                "4. Удалить группу вместе с контактами\n" +
                "5. Вывести все контакты в отсортированном виде\n" +
                "0. Выход\n");
        return scanner.nextLine();
    }
}