import java.util.HashMap;
import java.util.Scanner;

class Book {
    private String title;      // название
    private String author;     // автор
    private int copies;        // количество копий

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return String.format("Книга: \"%s\", автор: %s, копий: %d", title, author, copies);
    }
}

public class Library {
    public static void main(String[] args) {
        HashMap<String, Book> library = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Программа «Библиотека» (HashMap) ===\n");

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Найти книгу по ISBN");
            System.out.println("3. Удалить книгу по ISBN");
            System.out.println("4. Показать все книги");
            System.out.println("0. Выход");
            System.out.print("→ ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1: // Добавление
                    System.out.print("Введите ISBN: ");
                    String isbnAdd = scanner.nextLine();
                    System.out.print("Название: ");
                    String title = scanner.nextLine();
                    System.out.print("Автор: ");
                    String author = scanner.nextLine();
                    System.out.print("Количество копий: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();

                    library.put(isbnAdd, new Book(title, author, copies));
                    System.out.println("Книга успешно добавлена!");
                    break;

                case 2: // Поиск
                    System.out.print("Введите ISBN: ");
                    String isbnSearch = scanner.nextLine();
                    Book found = library.get(isbnSearch);
                    if (found != null) {
                        System.out.println("Найдено: " + found);
                    } else {
                        System.out.println("Книга с таким ISBN не найдена.");
                    }
                    break;

                case 3: // Удаление
                    System.out.print("Введите ISBN: ");
                    String isbnRemove = scanner.nextLine();
                    if (library.remove(isbnRemove) != null) {
                        System.out.println("Книга удалена.");
                    } else {
                        System.out.println("Книга с таким ISBN не найдена.");
                    }
                    break;

                case 4: // Все книги
                    if (library.isEmpty()) {
                        System.out.println("Библиотека пуста.");
                    } else {
                        System.out.println("Все книги в библиотеке:");
                        library.forEach((isbn, book) ->
                                System.out.println("ISBN: " + isbn + " → " + book));
                    }
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}