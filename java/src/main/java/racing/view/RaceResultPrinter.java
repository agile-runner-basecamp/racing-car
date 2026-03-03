package racing.view;

import java.util.List;

import racing.domain.Cars;

public class RaceResultPrinter {
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    public void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(Cars cars) {
        List<String> lines = cars.getResultLines();
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        System.out.println(String.join(", ", cars.getWinnerNames()) + WINNER_SUFFIX);
    }
}
