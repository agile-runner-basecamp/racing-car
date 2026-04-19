package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @DisplayName("위치는 0 이상이어야 한다")
    @Test
    void negativeValue() {
        assertThatThrownBy(() -> Position.of(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("next는 위치가 1 증가한 새 Position을 반환한다")
    @Test
    void next() {
        // given
        Position position = Position.of(3);

        // when
        Position moved = position.next();

        // then
        assertThat(moved).isEqualTo(Position.of(4));
    }

    @DisplayName("위치가 더 크면 isGreaterThan은 true를 반환한다")
    @Test
    void isGreaterThanTrue() {
        Position bigger = Position.of(5);
        Position smaller = Position.of(3);

        assertThat(bigger.isGreaterThan(smaller)).isTrue();
    }

    @DisplayName("위치가 같거나 작으면 isGreaterThan은 false를 반환한다")
    @Test
    void isGreaterThanFalse() {
        Position position = Position.of(3);

        assertThat(position.isGreaterThan(Position.of(3))).isFalse();
        assertThat(position.isGreaterThan(Position.of(5))).isFalse();
    }

    @DisplayName("같은 값의 Position은 동등하다")
    @Test
    void equality() {
        Position p1 = Position.of(3);
        Position p2 = Position.of(3);

        assertThat(p1).isEqualTo(p2);
        assertThat(p1).hasSameHashCodeAs(p2);
    }

    @DisplayName("toString은 위치만큼의 대시를 반환한다")
    @Test
    void toStringReturnsDashes() {
        Position position = Position.of(3);

        assertThat(position.toString()).isEqualTo("---");
    }
}