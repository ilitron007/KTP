import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {

    @DataProcessor
    public List<String> transform(List<String> data) {

        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}