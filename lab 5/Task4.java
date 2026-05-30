import java.util.Scanner;
import java.util.regex.Pattern;


public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 4: Проверка IPv4-адреса ===");
        System.out.print("Введите IP-адрес: ");
        String ip = scanner.nextLine().trim();

        String octet = "(?:25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
        String regex = "^" + octet + "\\." + octet + "\\." + octet + "\\." + octet + "$";

        if (Pattern.matches(regex, ip)) {
            System.out.println("IP-адрес корректный!");
        } else {
            System.out.println("Некорректный IP-адрес!");
        }

        scanner.close();
    }
}