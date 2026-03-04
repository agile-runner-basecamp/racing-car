package racing.domain;

public class Car {
    public static final int STANDARD = 4;

    private final CarName carName;
    private Position position;

    private Car(String name, int position) {
        this.carName = CarName.of(name);
        this.position = Position.of(position);
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }

    public void moveForward(int number) {
        if (number >= STANDARD) {
            this.position = position.next();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return carName.toString();
    }
}
