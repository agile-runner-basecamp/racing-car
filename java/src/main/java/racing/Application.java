package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        RandomGenerator generator = new RandomGenerator();
        OutputHandler out = new OutputHandler();
        InputHandler in = new InputHandler();

        InitData initData = initialize(scanner, in);
        Race race = new Race(initData.cars, generator, out);

        race.start(initData.finalRound);
    }

    // 자동차 이름과 라운드 수를 InitData로 묶어서 반환
    private static InitData initialize(Scanner scanner, InputHandler in) {
        String input = in.readCarNames(scanner);
        String[] carNames = input.split(",");

        for(int index=0; index<carNames.length; index++){
            carNames[index] = carNames[index].trim();
        }

        int finalRound = in.readFinalRound(scanner);

        // 각 자동차 객체 생성
        List<Car> carList = new ArrayList<>();
        for(String carName : carNames){
            carList.add(new Car(carName));
        }

        Cars cars = new Cars(carList);

        return new InitData(cars, finalRound);
    }

    private record InitData(Cars cars, int finalRound) {}
}
