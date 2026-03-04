package racing.io;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void showCarNamesRequestMessage() {
        System.out.println("경주할 자동차이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Override
    public void showTryCountRequestMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void showRoundResultMessage() {
        System.out.println("실행 결과");
    }

    @Override
    public void showRoundResult(Cars cars) {
        List<Car> carList = cars.getList();

        for (Car car : carList) {
            System.out.print(car.getName() + " : ");

            for (int position = 0; position < car.getPosition().toInt(); position++) {
                System.out.print("-");
            }

            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void showWinners(List<String> winners) {
        String winnersStr = String.join(", ", winners);
        System.out.println(winnersStr + "가 최종 우승했습니다.");
    }
}
