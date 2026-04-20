package racing;

public class Car {
    private static final int INIT_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    public Car(String name) {
        this.name = CarName.of(name);
        this.position = Position.of(INIT_POSITION);
    }

    public void move(MovingStrategy movingStrategy) {
        int value = movingStrategy.generateValue();
        if (value >= MOVE_THRESHOLD) {
            position = position.next();
        }
    }

    public CarName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
