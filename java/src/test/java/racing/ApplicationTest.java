package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {
    @Test
    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다")
    void carNameShouldThrowWhenEmpty() {
        assertThatThrownBy(() -> new racing.domain.CarName(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 넘으면 예외가 발생한다")
    void carNameShouldThrowWhenTooLong() {
        assertThatThrownBy(() -> new racing.domain.CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수는 1보다 작으면 예외가 발생한다")
    void attemptCountShouldThrowWhenZeroOrLess() {
        assertThatThrownBy(() -> new racing.domain.AttemptCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("랜덤 값 4 이상이면 이동한다")
    void moveStrategyShouldMoveWhenRandomIsAtLeast4() {
        racing.strategy.RandomMoveStrategy strategy = new racing.strategy.RandomMoveStrategy(() -> 4);
        assertThat(strategy.canMove()).isTrue();
    }

    @Test
    @DisplayName("랜덤 값 4 미만이면 이동하지 않는다")
    void moveStrategyShouldStopWhenRandomLessThan4() {
        racing.strategy.RandomMoveStrategy strategy = new racing.strategy.RandomMoveStrategy(() -> 3);
        assertThat(strategy.canMove()).isFalse();
    }

    @Test
    @DisplayName("동점자는 여러명일 수 있다")
    void winnersCanTie() {
        java.util.List<racing.domain.Car> carList = java.util.List.of(
                new racing.domain.Car(new racing.domain.CarName("kim")),
                new racing.domain.Car(new racing.domain.CarName("lee")),
                new racing.domain.Car(new racing.domain.CarName("park"))
        );
        racing.domain.Cars cars = new racing.domain.Cars(carList);

        racing.domain.Cars result = cars.race(java.util.List.of(true, false, true));

        assertThat(result.getWinnerNames()).containsExactly("kim", "park");
    }

    @Test
    @DisplayName("파싱한 시도 횟수가 정수가 아니면 예외가 발생한다")
    void parseAttemptCountShouldThrowWhenNotInteger() {
        racing.io.RaceInputParser parser = new racing.io.RaceInputParser();
        assertThatThrownBy(() -> parser.parseAttemptCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 정수여야 합니다.");
    }

}
