package racing;

public class FixedMovingStrategy implements MovingStrategy {
    private final int fixedValue;

    public FixedMovingStrategy(int value) {
        this.fixedValue = value;
    }

    @Override
    public int generateValue() {
        return fixedValue;
    }
}