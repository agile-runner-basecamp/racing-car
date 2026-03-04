package racing.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountParserTest {

    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void parse() {
        // given
        String userInput = "a";

        // when & then
        Assertions.assertThatThrownBy(() -> TryCountParser.parse(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 입력할 수 있습니다.");
    }

}