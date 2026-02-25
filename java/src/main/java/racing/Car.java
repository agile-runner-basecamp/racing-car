package racing;

public class Car {
    private String carName;
    private int position = 0;

    Car(String carName){
        this.carName = carName;
    }

    public void move(int ranNum){
        if(ranNum >= 4){
            position += 1;
        }
    }

    public String getName(){
        return carName;
    }

    public int getPosition(){
        return position;
    }


}

