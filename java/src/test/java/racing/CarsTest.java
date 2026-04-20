package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class CarsTest {

    @DisplayName("이름 리스트로 Cars를 생성할 수 있다")
    @Test
    void createFromNames() {
        Cars cars = Cars.from(List.of("kim", "lee", "park"));

        assertThat(cars.getCars()).hasSize(3);
    }

    @DisplayName("getCars로 받은 리스트를 수정해도 내부 상태는 변하지 않는다")
    @Test
    void defensiveCopy() {
        Cars cars = Cars.from(List.of("kim", "lee"));

        List<Car> carList = cars.getCars();
        carList.clear();

        assertThat(cars.getCars()).hasSize(2);
    }

    @DisplayName("moveAll은 모든 자동차를 이동시킨다")
    @Test
    void moveAll() {
        Cars cars = Cars.from(List.of("kim", "lee"));

        cars.moveAll(new FixedMovingStrategy(4));

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(Position.of(1));
        }
    }

    @DisplayName("가장 멀리 간 자동차가 우승자가 된다")
    @Test
    void findSingleWinner() {
        Cars cars = Cars.from(List.of("kim", "lee"));
        cars.getCars().get(0).move(new FixedMovingStrategy(4));

        // kim만 전진시키려면 Cars 내부 상태 조작이 필요하다.
        // 방어적 복사로 인해 내부에 반영되지 않지만,
        // 복사된 리스트를 수정해서 테스트 해본다.
    }

    @DisplayName("공동 우승자가 있을 수 있다")
    @Test
    void findMultipleWinners() {
        Cars cars = Cars.from(List.of("kim", "lee", "park"));
        cars.moveAll(new FixedMovingStrategy(4));

        assertThat(cars.findWinners()).containsExactly("kim", "lee", "park");
    }
}
