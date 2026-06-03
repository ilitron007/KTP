import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {

    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            data = Files.readAllLines(Paths.get(source));
            System.out.println("Данные загружены.");
        } catch (IOException e) {
            System.out.println("Ошибка загрузки данных: " + e.getMessage());
        }
    }

    public void processData() {
        ExecutorService executor = Executors.newFixedThreadPool(processors.size());

        try {
            for (Object processor : processors) {
                for (Method method : processor.getClass().getDeclaredMethods()) {

                    if (method.isAnnotationPresent(DataProcessor.class)) {

                        Future<List<String>> future =
                                executor.submit(() ->
                                        (List<String>) method.invoke(processor, data));

                        data = future.get();
                    }
                }
            }

            System.out.println("Обработка завершена.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    public void saveData(String destination) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(destination))) {

            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Данные сохранены.");

        } catch (IOException e) {
            System.out.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }
}