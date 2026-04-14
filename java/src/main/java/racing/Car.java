package racing;


import racing.valueObjects.CarName;
import racing.valueObjects.Position;

public class Car {

    private CarName carName;
    private Position position;

    private Car(String carName){
        this.carName = CarName.from(carName);
        this.position = Position.from(0);
    }

    public static Car of(String carName){
        return new Car(carName);
    }

    public void move(Integer randomValue){
        if (randomValue == null){
            throw new IllegalArgumentException("랜덤한 숫자는 null일 수 없습니다. | " + carName.toString());
        }
        if (randomValue >= 4){
            this.position = this.position.advance();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }



}
