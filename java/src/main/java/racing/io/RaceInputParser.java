package racing.io;

import java.util.ArrayList;
import java.util.List;

import racing.domain.AttemptCount;
import racing.domain.Car;
import racing.domain.CarName;
import racing.domain.Cars;

public class RaceInputParser {
    private static final String NAME_SEPARATOR = ",";

    public Cars parseCars(String rawCarNames) {
        String[] tokens = rawCarNames.split(NAME_SEPARATOR);
        List<Car> cars = new ArrayList<>();
        for (String token : tokens) {
            cars.add(new Car(new CarName(token.trim())));
        }
        return new Cars(cars);
    }

    public AttemptCount parseAttemptCount(String rawAttemptCount) {
        try {
            return new AttemptCount(Integer.parseInt(rawAttemptCount.trim()));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수여야 합니다.", exception);
        }
    }
}
