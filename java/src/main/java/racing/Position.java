package racing;

import java.util.Objects;

// VO
public class Position {
    private final int value;

    private Position(int value) {
        if (value < 0) throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        this.value = value;
    }

    public static Position of(int value) {
        return new Position(value);
    }

    public Position next() {
        return new Position(value + 1);
    }

    // 비교는 Position 의 책임
    public boolean isGreaterThan(Position o) {
        return this.value > o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return this.value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        StringBuilder trace = new StringBuilder();
        for (int i = 0; i < value; i++) {
            trace.append('-');
        }
        return trace.toString();
    }
}