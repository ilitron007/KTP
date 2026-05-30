import java.io.*;

public class FileCopy {

    public static void main(String[] args) {
        String source = "input.txt";      // исходный файл
        String destination = "output.txt"; // файл назначения

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            int linesCopied = 0;

            System.out.println("Начало копирования файла \"" + source + "\" в \"" + destination + "\"...");

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                linesCopied++;
                System.out.println("Скопирована строка " + linesCopied + ": " + line);
            }

            System.out.println("\nКопирование успешно завершено!");
            System.out.println("Скопировано строк: " + linesCopied);

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл \"" + source + "\" не найден!");
        } catch (IOException e) {
            System.err.println("Ошибка чтения/записи файла: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}