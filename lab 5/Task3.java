import java.util.Scanner;
import java.util.regex.*;


public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        String regex = "([a-z])([A-Z])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("\nНайденные последовательности:");
        boolean found = false;

        while (matcher.find()) {
            System.out.println(" → !" + matcher.group() + "!");
            found = true;
        }

        if (!found) {
            System.out.println("Таких последовательностей не найдено.");
        }

        scanner.close();
    }
}