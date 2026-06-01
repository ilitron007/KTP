import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {

    private final Queue<Product> products =
            new LinkedList<>();

    public synchronized void addProduct(Product product) {
        products.add(product);
    }

    public synchronized Product getProduct() {

        if (products.isEmpty()) {
            return null;
        }

        return products.poll();
    }

    public synchronized boolean isEmpty() {
        return products.isEmpty();
    }
}