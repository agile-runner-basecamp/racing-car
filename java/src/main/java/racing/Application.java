package racing;

import java.util.Scanner;

import racing.domain.AttemptCount;
import racing.domain.Cars;
import racing.io.RaceInputParser;
import racing.io.RaceInputReader;
import racing.service.RaceEngine;
import racing.strategy.RandomMoveStrategy;
import racing.view.RaceResultPrinter;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RaceInputReader inputReader = new RaceInputReader(scanner);
        RaceInputParser parser = new RaceInputParser();
        RaceResultPrinter output = new RaceResultPrinter();
        RaceEngine engine = new RaceEngine(new RandomMoveStrategy());

        String carNames = inputReader.readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String attemptCountText = inputReader.readLine("시도할 횟수는 몇 회인가요?");

        Cars cars = parser.parseCars(carNames);
        AttemptCount attemptCount = parser.parseAttemptCount(attemptCountText);

        output.printResultHeader();

        for (int i = 0; i < attemptCount.getValue(); i++) {
            cars = engine.race(cars);
            output.printRoundResult(cars);
        }

        output.printWinners(cars);
    }
}
