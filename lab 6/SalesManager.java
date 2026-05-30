import java.util.*;

public class SalesManager {
    private TreeSet<Product> soldProducts = new TreeSet<>();
    private Map<String, Integer> salesCount = new HashMap<>();

    public void addSale(Product product) {
        soldProducts.add(product);
        salesCount.put(product.getName(),
                salesCount.getOrDefault(product.getName(), 0) + 1);
    }

    public void printSoldProducts() {
        System.out.println("=== Проданные товары ===");
        soldProducts.forEach(System.out::println);
    }

    public double getTotalSales() {
        double total = 0;
        for (Product p : soldProducts) {
            total += p.getPrice() * salesCount.get(p.getName());
        }
        return total;
    }

    public void printMostPopular() {
        String top = null;
        int max = 0;
        for (var entry : salesCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                top = entry.getKey();
            }
        }
        if (top != null) {
            System.out.println("Самый популярный товар: " + top + " (" + max + " шт.)");
        }
    }

    public void printStatistics() {
        System.out.println("\n" + "=".repeat(40));
        printSoldProducts();
        System.out.printf("Общая сумма продаж: %.2f ₽\n", getTotalSales());
        printMostPopular();
        System.out.println("=".repeat(40));
    }
}