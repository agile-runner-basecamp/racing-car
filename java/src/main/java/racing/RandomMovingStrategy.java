package racing;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final Random randomValue = new Random();

    @Override
    public int generateValue() {
        return randomValue.nextInt(10);
    }
}