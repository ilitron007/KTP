import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ArraySumExecutor {

    static class SumTask implements Callable<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int sum = 0;

            for (int i = start; i < end; i++) {
                sum += array[i];
            }

            System.out.println(
                    Thread.currentThread().getName() +
                            " вычислил сумму: " + sum);

            return sum;
        }
    }

    public static void main(String[] args) throws Exception {

        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int threadsCount = 4;

        ExecutorService executor =
                Executors.newFixedThreadPool(threadsCount);

        List<Future<Integer>> futures = new ArrayList<>();

        int partSize = array.length / threadsCount;

        for (int i = 0; i < threadsCount; i++) {

            int start = i * partSize;

            int end = (i == threadsCount - 1)
                    ? array.length
                    : start + partSize;

            futures.add(
                    executor.submit(
                            new SumTask(array, start, end)
                    )
            );
        }

        int totalSum = 0;

        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();

        System.out.println("Общая сумма массива = " + totalSum);
    }
}