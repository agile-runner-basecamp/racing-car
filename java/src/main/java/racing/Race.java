package racing;

import java.util.ArrayList;
import java.util.List;

public class Race {
    // 1. 매라운드 전진 결과 출력
    // 2. 우승하면 끝내기
    private final Cars cars;
    private final RandomGenerator generator;
    private final OutputHandler out;

    public Race(Cars cars, RandomGenerator generator, OutputHandler out){
        this.cars = cars;
        this.generator = generator;
        this.out = out;
    }

    public void start(int finalRound) {
        for(int round=0; round<finalRound; round++){
            cars.moveAll(generator);

            for(Car car : cars.getCars()){
                out.printResult(car);
            }

            out.println();
        }

        out.printWinners(cars.findWinners());
    }
}
