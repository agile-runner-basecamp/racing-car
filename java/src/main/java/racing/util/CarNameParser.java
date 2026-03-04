package racing.util;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public static final String delimiter = ",";

    public static List<String> parse(String userInput) {
        return Arrays.asList(userInput.split(delimiter));
    }
}
