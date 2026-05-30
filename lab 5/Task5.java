import java.util.Scanner;
import java.util.regex.*;

/**
 * ЛАБОРАТОРНАЯ РАБОТА №5 — Задание 5
 * Поиск всех слов, начинающихся с заданной буквы
 */
public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите букву (латинскую): ");
        String input = scanner.nextLine().trim();

        if (input.length() != 1 || !input.matches("[a-zA-Z]")) {
            System.out.println("Ошибка! Введите одну латинскую букву.");
            scanner.close();
            return;
        }

        char letter = input.charAt(0);
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        String regex = "\\b[" + letter + Character.toLowerCase(letter) + "]\\w*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("\nНайденные слова:");
        boolean found = false;

        while (matcher.find()) {
            System.out.println(" → " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Слов, начинающихся с буквы '" + letter + "', не найдено.");
        }

        scanner.close();
    }
}