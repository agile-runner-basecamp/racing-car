package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = new ArrayList<>(cars); // 방어적 복사?
    }

    public void playOneRound(){
        for(int i = 0; i < cars.size(); i++){
            Car car = cars.get(i);
            Random random = new Random();
            int ranNum = random.nextInt(10);
            car.move(ranNum);
        }
    }

    public int size() {
        return cars.size();
    }

    public Car getCarByIndex(int index){
        return cars.get(index);
    }

    public List<String> getWinnerList(Cars cars){
        int maxPosition = 0;

        List<String> carList = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++){
            Car car = cars.getCarByIndex(i);
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }

        for(int i = 0; i < cars.size(); i++){
            Car car = cars.getCarByIndex(i);
            if(car.getPosition() == maxPosition){
                carList.add(car.getName());
            }
        }

        return carList;


    }
}
