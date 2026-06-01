import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        Warehouse warehouse =
                new Warehouse();

        warehouse.addProduct(
                new Product("Телевизор", 40));
        warehouse.addProduct(
                new Product("Холодильник", 60));
        warehouse.addProduct(
                new Product("Стиральная машина", 50));
        warehouse.addProduct(
                new Product("Микроволновка", 20));
        warehouse.addProduct(
                new Product("Компьютер", 30));
        warehouse.addProduct(
                new Product("Принтер", 15));

        Semaphore semaphore =
                new Semaphore(150);

        Loader loader1 =
                new Loader(
                        "Грузчик-1",
                        warehouse,
                        semaphore);

        Loader loader2 =
                new Loader(
                        "Грузчик-2",
                        warehouse,
                        semaphore);

        Loader loader3 =
                new Loader(
                        "Грузчик-3",
                        warehouse,
                        semaphore);

        loader1.start();
        loader2.start();
        loader3.start();

        loader1.join();
        loader2.join();
        loader3.join();

        System.out.println(
                "\nВсе товары перенесены.");
    }
}