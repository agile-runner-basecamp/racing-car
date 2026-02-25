package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Race {
    // 1. 자동차 이름, 라운드 입력
    // 2. 매라운드 전진 결과 출력
    // 3. 우승하면 끝내기
    private final List<Car> carList;
    private final RandomGenerator generator;

    public Race(List<Car> carList, RandomGenerator generator){
        this.carList = carList;
        this.generator = generator;
    }

    public void start(int finalRound) {
        // 종료조건: 하나라도 finalRound에 도달했을 때
        while(!finish(finalRound)){
            //각 자동차 랜덤 숫자 굴리기
            randomGame();
            //밖으로 분리
            for(Car car : carList){
                System.out.println(car.getName());
                for(int i=0; i<car.getPosition(); i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println("========");

        }
        System.out.println("게임 끝");
    }

    private boolean finish(int finalRound) {
        for(Car car : carList){
            if(car.getPosition() >= finalRound){
                return true;
            }
        }
        //우승자가 없을 때
        return false;
    }

    private void randomGame() {
        int result = 0;
        for(Car car : carList){
            result = generator.generate();
            //랜덤 숫자가 4이상 9이하일 때 전진
            if(result >= 4 && result <= 9){
                car.move();
            }
        }
    }
}
