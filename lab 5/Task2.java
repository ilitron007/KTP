import java.util.Scanner;
import java.util.regex.Pattern;


public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Требования к паролю:");
        System.out.println("• Длина от 8 до 16 символов");
        System.out.println("• Только латинские буквы и цифры");
        System.out.println("• Минимум одна заглавная буква");
        System.out.println("• Минимум одна цифра\n");

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{8,16}$";

        if (Pattern.matches(regex, password)) {
            System.out.println("Пароль корректный!");
        } else {
            System.out.println("Пароль НЕ соответствует требованиям.");
        }

        scanner.close();
    }
}