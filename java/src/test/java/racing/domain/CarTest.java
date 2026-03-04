package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생한다.")
    @Test
    void of() {
        // given
        String carName = "abcdef";

        // when & then
        assertThatThrownBy(() -> Car.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("생성된 숫자가 4이상 일 경우 전진한다.")
    @Test
    void moveForward() {
        // given
        int number = 4;
        Car car = Car.of("kim");

        // when
        car.moveForward(number);

        // then
        assertThat(car.getPosition().toInt()).isEqualTo(1);
    }

    @DisplayName("생성된 숫자가 미만일 경우 정지한다.")
    @Test
    void moveForward_stop() {
        // given
        int number = 3;
        Car car = Car.of("kim");

        // when
        car.moveForward(number);

        // then
        assertThat(car.getPosition().toInt()).isEqualTo(0);
    }
}