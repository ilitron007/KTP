import java.util.concurrent.Semaphore;

public class Loader extends Thread {

    private static int currentWeight = 0;

    private static final Object lock =
            new Object();

    private Warehouse warehouse;

    private Semaphore semaphore;

    public Loader(String name,
                  Warehouse warehouse,
                  Semaphore semaphore) {

        super(name);

        this.warehouse = warehouse;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {

            while (!warehouse.isEmpty()) {

                Product product =
                        warehouse.getProduct();

                if (product == null) {
                    break;
                }

                semaphore.acquire(product.getWeight());

                synchronized (lock) {

                    currentWeight +=
                            product.getWeight();

                    System.out.println(
                            getName()
                                    + " взял "
                                    + product.getName()
                                    + " ("
                                    + product.getWeight()
                                    + " кг). "
                                    + "Текущий вес: "
                                    + currentWeight
                    );

                    if (currentWeight >= 150) {

                        System.out.println(
                                "\nГрузчики набрали "
                                        + currentWeight
                                        + " кг и отправились "
                                        + "на другой склад.\n"
                        );

                        Thread.sleep(2000);

                        semaphore.release(
                                currentWeight);

                        currentWeight = 0;
                    }
                }

                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}