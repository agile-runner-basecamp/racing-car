package io;

import racing.Car;
import racing.Cars;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler{

    @Override
    public void showGameStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Override
    public void showAttemptCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void showResultMessage(){
        System.out.println("실행 결과");
    }

    public void showRoundResult(Cars cars){
        for(int i = 0; i < cars.size(); i++){
            Car car = cars.getCarByIndex(i);
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void showWinnerName(List<String> carName) {
        for(int i = 0; i < carName.size(); i++){
            System.out.print(carName.get(i) + ", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
