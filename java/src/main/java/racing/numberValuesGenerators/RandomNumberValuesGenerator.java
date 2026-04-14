package racing.numberValuesGenerators;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberValuesGenerator implements NumberValuesGenerator {

    private final int MIN_RANDOM_VALUE = 0;
    private final int MAX_RANDOM_VALUE = 9;

    private RandomNumberValuesGenerator(){
    }

    public static RandomNumberValuesGenerator of(){
        return new RandomNumberValuesGenerator();
    }

    @Override
    public List<Integer> getNumberValues(int numberCount) {
        return ThreadLocalRandom.current()
                .ints(numberCount, MIN_RANDOM_VALUE, MAX_RANDOM_VALUE + 1) // count개, 0~9
                .boxed()
                .toList();
    }
}
