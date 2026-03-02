package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> values) {
        validate(values);
        this.values = List.copyOf(values);
    }

    private void validate(List<Car> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차는 1대 이상이어야 합니다.");
        }
    }

    public Cars race(List<Boolean> decisions) {
        if (decisions.size() != this.values.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 수와 전진 여부 수가 일치하지 않습니다.");
        }

        List<Car> movedCars = new ArrayList<>();
        for (int i = 0; i < this.values.size(); i++) {
            Car current = this.values.get(i);
            boolean canMove = decisions.get(i);
            movedCars.add(current.move(canMove));
        }

        return new Cars(movedCars);
    }

    public List<String> getResultLines() {
        List<String> resultLines = new ArrayList<>();
        for (Car car : this.values) {
            resultLines.add(car.toResultLine());
        }
        return resultLines;
    }

    public List<String> getWinnerNames() {
        int maxPosition = this.findMaxPosition();
        List<String> winnerNames = new ArrayList<>();
        for (Car car : this.values) {
            if (car.getPositionValue() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private int findMaxPosition() {
        int max = this.values.get(0).getPositionValue();
        for (Car car : this.values) {
            if (car.getPositionValue() > max) {
                max = car.getPositionValue();
            }
        }
        return max;
    }

    public int getSize() {
        return this.values.size();
    }
}
