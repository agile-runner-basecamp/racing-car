package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameParserTest {

    @DisplayName("자동차 이름을 쉼표를 기준으로 구분할 수 있다.")
    @Test
    void parse() {
        // given
        String userInput = "kim,lee,park";

        // when
        List<String> carNames = CarNameParser.parse(userInput);

        // then
        assertThat(carNames).containsExactlyInAnyOrder("kim", "lee", "park");
    }
}