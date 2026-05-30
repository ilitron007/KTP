import java.io.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

// Собственное исключение
class CustomInputMismatchException extends Exception {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}

// Класс для логирования исключений
class ExceptionLogger {
    private static final String LOG_FILE = "exceptions.log";

    public static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println("=== " + new Date() + " ===");
            writer.println("Тип исключения: " + e.getClass().getName());
            writer.println("Сообщение: " + e.getMessage());
            writer.println("Стек вызовов:");
            e.printStackTrace(writer);
            writer.println("-----------------------------------\n");
            System.out.println("Исключение записано в файл " + LOG_FILE);
        } catch (IOException ioEx) {
            System.err.println("Не удалось записать лог в файл: " + ioEx.getMessage());
        }
    }
}

public class CustomInputMismatchDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите целое число: ");
            int number = readInt(scanner);
            System.out.println("Вы успешно ввели число: " + number);

        } catch (CustomInputMismatchException e) {
            System.err.println("Ошибка ввода: " + e.getMessage());
            ExceptionLogger.logException(e);   // Логирование

        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);   // Логирование

        } finally {
            scanner.close();
        }
    }

    // Метод для безопасного чтения целого числа
    public static int readInt(Scanner scanner) throws CustomInputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // очистка буфера ввода
            throw new CustomInputMismatchException("Введённое значение не является целым числом!");
        }
    }
}