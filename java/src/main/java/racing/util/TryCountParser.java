package racing.util;

import static racing.ErrorCode.TRY_COUNT_TYPE;

public class TryCountParser {
    public static int parse(String userInput) {
        for (char ch : userInput.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(TRY_COUNT_TYPE.getMessage());
            }
        }
        return Integer.parseInt(userInput);
    }
}
