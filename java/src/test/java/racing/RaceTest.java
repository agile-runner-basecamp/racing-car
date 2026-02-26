package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @DisplayName("finalRound에 먼저 다다르는 자동차가 우승한다.")
    @Test
    void getWinners(){
        // given
        Cars cars = new Cars(List.of(
                new Car("kim"),
                new Car("lee"),
                new Car("nam")
        ));

        cars.getCars().get(0).move();
        cars.getCars().get(2).move();

        List<Car> winners = cars.findWinners();

        // then
        assertEquals(2, winners.size());
        assertTrue(winners.stream().anyMatch(c -> c.getName().equals("kim")));
        assertTrue(winners.stream().anyMatch(c -> c.getName().equals("nam")));
        assertFalse(winners.stream().anyMatch(c -> c.getName().equals("lee")));
    }


}