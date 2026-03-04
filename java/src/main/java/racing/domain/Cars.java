package racing.domain;

import racing.util.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static racing.ErrorCode.CAR_NAME_DUPLICATE;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(List<String> carNames) {
        validateDuplication(carNames);
        return createCarsFrom(carNames);
    }

    public void playSingleRound(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int number = numberGenerator.generate();

            car.moveForward(number);
        }
    }

    public List<String> findWinners() {
        Position maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                        .orElseThrow();

        return cars.stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .map(Car::getName)
                .toList();
    }

    public List<Car> getList() {
        return new ArrayList<>(cars);
    }

    private static void validateDuplication(List<String> carNames) {
        HashSet<String> uniqueNames = new HashSet<>(carNames);
        if (carNames.size() != uniqueNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private static Cars createCarsFrom(List<String> carNames) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = Car.of(carName);
            carList.add(car);
        }
        return new Cars(carList);
    }
}
