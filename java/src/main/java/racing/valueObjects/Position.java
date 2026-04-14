package racing.valueObjects;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int position){
        validate(position);
        this.position = position;
    }

    public static Position from(int position){
        return new Position(position);
    }

    public Position advance(){
        return new Position(this.position + 1);
    }

    public int value(){
        return this.position;
    }

    private void validate(int position){
        if (position<0){
            throw new IllegalArgumentException("차의 위치는 음수일 수 없습니다.");
        }
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
