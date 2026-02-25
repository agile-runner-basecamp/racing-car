package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        RandomGenerator generator = new RandomGenerator();
        InitData initData = initialize(scanner);
        Race race = new Race(initData.carList, generator);

        race.start(initData.finalRound);
    }
    // 자동차 이름과 라운드 수를 InitData로 묶어서 반환
    private static InitData initialize(Scanner scanner) {
        // 출력 로직 분리
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");

        List<Car> carList = new ArrayList<>();
        String input = scanner.nextLine();
        String[] carNames = input.split(",");

        for(int i=0; i<carNames.length; i++){
            carNames[i] = carNames[i].trim();
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int finalRound = scanner.nextInt();

        // 각 자동차 객체 생성
        for(String carName : carNames){
            carList.add(new Car(carName));
        }

        return new InitData(carList, finalRound);
    }

    private record InitData(List<Car> carList, int finalRound) {}
}
