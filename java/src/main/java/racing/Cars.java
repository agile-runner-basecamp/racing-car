package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    // 생성자 (방어적 복사)
    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    // 자동차 이름 리스트로 만들때
    public static Cars from (List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return new Cars(carList);
    }

    // 방어적 복사
    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void moveAll(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<String> findWinners() {
        Position maxPosition = Position.of(0);
        for (Car car : cars) {
            if (car.getPosition().isGreaterThan(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition().equals(maxPosition)) {
                winners.add(car.getName().toString());
            }
        }
        return winners;
    }
}