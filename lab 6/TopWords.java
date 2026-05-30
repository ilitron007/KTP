import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "text.txt";

        File file = new File(filePath);
        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase()
                        .replaceAll("[^a-zа-я0-9]", "");

                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        Collections.sort(list, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("=== ТОП-10 самых частых слов ===\n");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.printf("%d. %s — %d раз\n",
                    i + 1, list.get(i).getKey(), list.get(i).getValue());
        }
    }
}