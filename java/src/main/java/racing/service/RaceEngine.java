package racing.service;

import java.util.ArrayList;
import java.util.List;

import racing.domain.Cars;
import racing.strategy.MoveStrategy;

public class RaceEngine {
    private final MoveStrategy moveStrategy;

    public RaceEngine(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Cars race(Cars cars) {
        List<Boolean> decisions = createDecisions(cars.getSize());
        return cars.race(decisions);
    }

    private List<Boolean> createDecisions(int carCount) {
        List<Boolean> decisions = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            decisions.add(this.moveStrategy.canMove());
        }
        return decisions;
    }
}
