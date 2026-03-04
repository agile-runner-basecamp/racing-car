package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.FixedNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("")
    @Test
    void from_duplication() {
        // given
        List<String> carNames = List.of("kim", "kim");

        // when & then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("자동차 이름 리스트로부터 Cars 일급컬렉션을 생성할 수 있다.")
    @Test
    void from() {
        // given
        List<String> carNames = List.of("kim", "lee", "park");

        // when
        Cars cars = Cars.from(carNames);

        // then
        assertThat(cars.getList()).hasSize(3);
    }

    @DisplayName("게임 종료 시점에 가장 멀리 이동한 자동차를 우승으로 한다.")
    @Test
    void findWinners() {
        // given
        List<String> carNames = List.of("kim", "lee", "park");
        Cars cars = Cars.from(carNames);

        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4, 3, 3);
        cars.playSingleRound(fixedNumberGenerator);

        // when
        List<String> winners = cars.findWinners();

        // then
        assertThat(winners).containsExactlyInAnyOrder("kim");
    }
}