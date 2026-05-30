import java.util.Scanner;
import java.util.regex.*;


public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст");
        String text = scanner.nextLine();


        String regex = "\\d+\\.\\d+|\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("\nНайденные числа:");
        boolean found = false;

        while (matcher.find()) {
            System.out.println(" → " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Числа в тексте не найдены.");
        }

        scanner.close();
    }
}