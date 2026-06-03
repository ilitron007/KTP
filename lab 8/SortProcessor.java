import java.util.List;
import java.util.stream.Collectors;

public class SortProcessor {

    @DataProcessor
    public List<String> sort(List<String> data) {

        return data.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}