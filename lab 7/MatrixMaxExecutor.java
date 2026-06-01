import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MatrixMaxExecutor {

    static class MaxTask implements Callable<Integer> {

        private final int[][] matrix;
        private final int startRow;
        private final int endRow;

        public MaxTask(int[][] matrix,
                       int startRow,
                       int endRow) {
            this.matrix = matrix;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public Integer call() {

            int max = Integer.MIN_VALUE;

            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < matrix[i].length; j++) {

                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }

            System.out.println(
                    Thread.currentThread().getName() +
                            " нашёл максимум: " + max);

            return max;
        }
    }

    public static void main(String[] args)
            throws Exception {

        int[][] matrix = {
                {12, 5, 18, 7},
                {25, 9, 13, 17},
                {3, 99, 4, 22},
                {41, 56, 2, 11}
        };

        int threadsCount = 2;

        ExecutorService executor =
                Executors.newFixedThreadPool(threadsCount);

        List<Future<Integer>> futures = new ArrayList<>();

        int rowsPerThread =
                matrix.length / threadsCount;

        for (int i = 0; i < threadsCount; i++) {

            int start = i * rowsPerThread;

            int end = (i == threadsCount - 1)
                    ? matrix.length
                    : start + rowsPerThread;

            futures.add(
                    executor.submit(
                            new MaxTask(matrix, start, end)
                    )
            );
        }

        int globalMax = Integer.MIN_VALUE;

        for (Future<Integer> future : futures) {
            globalMax =
                    Math.max(globalMax, future.get());
        }

        executor.shutdown();

        System.out.println(
                "Максимальный элемент матрицы = "
                        + globalMax);
    }
}