package racing;

public class Car {
    // 자동차 이름, 현재 위치
    private final String name;
    private int position;

    public Car(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move(){
        position += 1;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

}
