package racing.valueObjects;

import java.util.Objects;

public class CarName {
    private final String carName;

    private CarName(String carName){
        validate(carName);
        this.carName = carName;
    }

    public static CarName from(String carName){
        return new CarName(carName);
    }

    private void validate(String carName){
        if (carName==null || carName.isBlank()){
            throw new IllegalArgumentException("차 이름은 공백일 수 없습니다.");
        }
        if (carName.length() > 5){
            throw new IllegalArgumentException("차 이름은 5자 이하로 설정되어야 합니다.");
        }
    }

    public String value() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }

    @Override
    public String toString() {
        return carName;
    }
}
