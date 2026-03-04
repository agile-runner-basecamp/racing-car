package racing.util;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FixedNumberGenerator implements NumberGenerator {

    private final Queue<Integer> numbers;

    public FixedNumberGenerator(Integer... insertNumbers) {
        this.numbers = new ArrayDeque<>(Arrays.asList(insertNumbers));
    }

    @Override
    public int generate() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.poll();
    }
}
