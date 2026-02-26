package racing;

import java.util.List;

public class OutputHandler {

    void printResult(Car car){
        System.out.print(car.getName() + " : ");
        for(int index=0; index<car.getPosition(); index++){
            System.out.print("-");
        }
        System.out.println();
    }

    void printWinners(List<Car> winners){
        for(int index=0; index<winners.size(); index++){
            System.out.print(winners.get(index).getName());
            if(index < winners.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public void println() {
        System.out.println();
    }
}
