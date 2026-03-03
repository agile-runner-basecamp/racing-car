package racing.domain;

public class Position {
    private static final int MIN_POSITION = 0;
    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_POSITION) {
            throw new IllegalArgumentException("[ERROR] 위치 값은 0 이상이어야 합니다.");
        }
    }

    public Position moveForward() {
        return new Position(this.value + 1);
    }

    public int getValue() {
        return this.value;
    }

    public String toProgressBar() {
        return "-".repeat(this.value);
    }
}
