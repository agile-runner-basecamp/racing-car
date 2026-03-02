package racing.strategy;

import java.util.function.IntSupplier;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;
    private final IntSupplier randomProvider;

    public RandomMoveStrategy() {
        this(() -> (int) (Math.random() * RANDOM_BOUND));
    }

    public RandomMoveStrategy(IntSupplier randomProvider) {
        this.randomProvider = randomProvider;
    }

    @Override
    public boolean canMove() {
        return this.randomProvider.getAsInt() >= FORWARD_THRESHOLD;
    }
}
