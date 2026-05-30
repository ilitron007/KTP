// Базовый класс
abstract class Establishment {
    private String name;
    private String address;
    private int capacity;

    protected static int count = 0;

    public Establishment(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        count++;
    }

    public Establishment() {
        this("Без названия", "Не указан", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Абстрактный метод
    public abstract void serve();

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Адрес: " + address);
        System.out.println("Вместимость: " + capacity);
    }

    public static int getCount() {
        return count;
    }
}

// Класс Cafe
class Cafe extends Establishment {
    private String cuisineType;
    private boolean hasWifi;

    public Cafe(String name, String address, int capacity, String cuisineType, boolean hasWifi) {
        super(name, address, capacity);
        this.cuisineType = cuisineType;
        this.hasWifi = hasWifi;
    }

    public Cafe() {
        super();
        this.cuisineType = "Неизвестно";
        this.hasWifi = false;
    }

    @Override
    public void serve() {
        System.out.println("Кафе обслуживает посетителей едой и напитками.");
    }

    public void printCafeInfo() {
        printInfo();
        System.out.println("Кухня: " + cuisineType);
        System.out.println("Wi-Fi: " + (hasWifi ? "Есть" : "Нет"));
    }
}

// Класс Shop
class Shop extends Establishment {
    private String productType;
    private boolean open24h;

    public Shop(String name, String address, int capacity, String productType, boolean open24h) {
        super(name, address, capacity);
        this.productType = productType;
        this.open24h = open24h;
    }

    public Shop() {
        super();
        this.productType = "Разное";
        this.open24h = false;
    }

    @Override
    public void serve() {
        System.out.println("Магазин продает товары.");
    }

    public void printShopInfo() {
        printInfo();
        System.out.println("Тип товаров: " + productType);
        System.out.println("Работает 24/7: " + (open24h ? "Да" : "Нет"));
    }
}

// Класс Library
class Library extends Establishment {
    private int bookCount;
    private boolean readingRoom;

    public Library(String name, String address, int capacity, int bookCount, boolean readingRoom) {
        super(name, address, capacity);
        this.bookCount = bookCount;
        this.readingRoom = readingRoom;
    }

    public Library() {
        super();
        this.bookCount = 0;
        this.readingRoom = false;
    }

    @Override
    public void serve() {
        System.out.println("Библиотека предоставляет книги читателям.");
    }

    public void printLibraryInfo() {
        printInfo();
        System.out.println("Количество книг: " + bookCount);
        System.out.println("Читальный зал: " + (readingRoom ? "Есть" : "Нет"));
    }
}

// Главный класс
public class lab2 {
    public static void main(String[] args) {

        Cafe cafe = new Cafe("CoffeeTime", "Москва", 50, "Итальянская", true);
        Shop shop = new Shop("TechStore", "СПб", 100, "Электроника", true);
        Library library = new Library("Городская библиотека", "Казань", 200, 10000, true);

        cafe.printCafeInfo();
        cafe.serve();

        System.out.println();

        shop.printShopInfo();
        shop.serve();

        System.out.println();

        library.printLibraryInfo();
        library.serve();

        System.out.println("\nВсего создано объектов: " + Establishment.getCount());
    }
}