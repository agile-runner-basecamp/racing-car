package racing;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(String carNames) {

        List<String> parsedCarNames = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
        validateCarNames(parsedCarNames);

        this.cars = new ArrayList<Car>();
        for (String carName : parsedCarNames) {
            cars.add(Car.of(carName));
        }
    }

    public static Cars of(String inputCarNames) {
        return new Cars(inputCarNames);
    }

    public void moveAll(List<Integer> randomValues) {
        validateRandomValues(randomValues);
        for (int i = 0; i < randomValues.size(); i++) {
            this.cars.get(i).move(randomValues.get(i));
        }
    }

    public int getSize(){
        return this.cars.size();
    }

    public List<String> getWinnerNames(){
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : this.cars) {
            Integer position = car.getPosition().value();
            if (position > maxPosition) {
                maxPosition = position;
                winners.clear();
                winners.add(car.getCarName().value());
            } else if (position == maxPosition) {
                winners.add(car.getCarName().value());
            }
        }
        return winners;
    }

    public List<String> getPositionViews(){
        return this.cars.stream().map(
                car -> car.getCarName() + " : " + "-".repeat(car.getPosition().value())).toList();
    }

    private void validateCarNames(List<String> parsedCarNames) {
        if (parsedCarNames == null || parsedCarNames.isEmpty()) {
            throw new IllegalArgumentException("차 이름은 1개 이상 입력되어야 합니다.");
        }
        parsedCarNames.forEach(carName -> {
            if (carName==null || carName.isBlank()) {
                throw new IllegalArgumentException("이름이 공백인 차가 포함될 수 없습니다.");
            }
        });
    }

    private void validateRandomValues(List<Integer> randomValues) {


        if (this.cars.size() != randomValues.size()) {
            throw new IllegalArgumentException("랜덤한 숫자의 개수는 라운드에 참여하는 차의 수와 같아야 합니다.");
        }
        if (randomValues.contains(null)) {
            throw new IllegalArgumentException("랜덤값 리스트에 null 값이 포함되어 있습니다.");
        }
    }
}
