public class ArrayAverage {

    public static void main(String[] args) {
        String[] arr = {"10", "20", "30", "40", "50", "abc", "70"};

        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                sum += num;
                count++;
                System.out.println("Элемент [" + i + "] = " + num);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива!");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом!");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("\nСреднее арифметическое: " + average);
        } else {
            System.out.println("Нет корректных чисел для расчёта среднего.");
        }
    }
}