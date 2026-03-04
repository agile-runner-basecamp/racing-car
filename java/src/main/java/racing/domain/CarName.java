package racing.domain;

import static racing.ErrorCode.CAR_NAME_LENGTH;

public class CarName {
    private final String name;

    private CarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH.getMessage());
        }
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String toString() {
        return name;
    }
}
