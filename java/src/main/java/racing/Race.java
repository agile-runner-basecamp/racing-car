package racing;

import java.io.IOException;
import java.util.List;

// 컨트롤러
public class Race {
    private final MovingStrategy movingStrategy;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Race(MovingStrategy movingStrategy, InputHandler inputHandler, OutputHandler outputHandler) {
        this.movingStrategy = movingStrategy;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    // 게임 흐름 제어
    public void run() throws IOException {
        // 자동차 이름, 라운드 입력
        outputHandler.printCarNameInput();
        Cars cars = Cars.from(inputHandler.readCarNames());
        outputHandler.printRoundInput();
        int round = inputHandler.readRound();

        // 라운드 별 결과 출력
        outputHandler.printResultHeader();
        for (int i = 1; i <= round; i++) {
            cars.moveAll(movingStrategy);
            outputHandler.printRoundResult(cars);
        }

        // 승자 출력
        List<String> winners = cars.findWinners();
        outputHandler.printWinners(winners);
    }
}