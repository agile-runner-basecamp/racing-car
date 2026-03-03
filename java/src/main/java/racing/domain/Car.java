package racing.domain;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(CarName name) {
        this(name, new Position());
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(boolean canMove) {
        if (!canMove) {
            return new Car(this.name, this.position);
        }

        return new Car(this.name, this.position.moveForward());
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getPositionValue() {
        return this.position.getValue();
    }

    public String toResultLine() {
        return this.getName() + " : " + this.position.toProgressBar();
    }
}
