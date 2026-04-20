package racing;

import java.util.List;

public class OutputHandler {
    public void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
    public void printRoundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public void printResultHeader() {
        System.out.println("실행 결과");
    }
    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }
    public void printWinners(List<String> winners) {
        System.out.print(winners.get(0));
        if (winners.size() > 1) {
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(", " + winners.get(i));
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }
}