package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(RandomGenerator generator){
        for(Car car : cars){
            int result = generator.generate();
            if(result >= 4){
                car.move();
            }
        }
    }

    public List<Car> findWinners(){
        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();

        for(Car car : cars){
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }

        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }

        return winners;
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
