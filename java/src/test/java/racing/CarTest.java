package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 생성 시 초기 위치는 0이다")
    @Test
    void initPosition() {
        Car car = new Car("kim");

        assertThat(car.getPosition()).isEqualTo(Position.of(0));
    }

    @DisplayName("이동 값이 4 이상이면 자동차가 전진한다")
    @Test
    void moveWhenValueIsFourOrMore() {
        // given
        Car car = new Car("kim");

        // when
        car.move(new FixedMovingStrategy(4));

        // then
        assertThat(car.getPosition()).isEqualTo(Position.of(1));
    }

    @DisplayName("이동 값이 4 미만이면 자동차는 전진하지 않는다")
    @Test
    void stopWhenValueIsLessThanFour() {
        // given
        Car car = new Car("kim");

        // when
        car.move(new FixedMovingStrategy(3));

        // then
        assertThat(car.getPosition()).isEqualTo(Position.of(0));
    }

    @DisplayName("여러 번 전진하면 위치가 누적된다")
    @Test
    void moveMultipleTimes() {
        // given
        Car car = new Car("kim");
        FixedMovingStrategy goStrategy = new FixedMovingStrategy(4);

        // when
        car.move(goStrategy);
        car.move(goStrategy);
        car.move(goStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(Position.of(3));
    }
}
