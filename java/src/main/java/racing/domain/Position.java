package racing.domain;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public Position next() {
        return new Position(this.position + 1);
    }

    public int compareTo(Position other) {
        return Integer.compare(this.position, other.position);
    }

    public int toInt() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
