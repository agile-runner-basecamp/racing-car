package racing;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public int generate(){
        return ThreadLocalRandom.current().nextInt(0, 10);
    }
}
