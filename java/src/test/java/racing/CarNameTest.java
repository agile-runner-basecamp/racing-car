package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @DisplayName("자동차 이름은 비어있을 수 없다")
    @Test
    void emptyOrNull() {
        assertThatThrownBy(() -> CarName.of(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarName.of(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    @Test
    void nameOverMaxLength() {
        assertThatThrownBy(() -> CarName.of("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 5자까지 허용된다")
    @Test
    void nameAtMaxLength() {
        // given
        String name = "abcde";

        // when
        CarName carName = CarName.of(name);

        // then
        assertThat(carName).isNotNull();
    }

    @DisplayName("같은 이름의 CarName은 동등하다")
    @Test
    void equality() {
        CarName name1 = CarName.of("kim");
        CarName name2 = CarName.of("kim");

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).hasSameHashCodeAs(name2);
    }
}