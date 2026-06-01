public class Main {
    public static void main(String[] args) {
        SalesManager sm = new SalesManager();

        sm.addSale(new Product("Ноутбук", 89990));
        sm.addSale(new Product("Мышь", 1290));
        sm.addSale(new Product("Клавиатура", 3490));
        sm.addSale(new Product("Ноутбук", 89990));
        sm.addSale(new Product("Монитор", 24990));
        sm.addSale(new Product("Мышь", 1290));

        sm.printStatistics();
    }
}