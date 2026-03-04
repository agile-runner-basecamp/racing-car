package racing;

import racing.domain.Cars;
import racing.domain.TryCount;
import racing.io.InputHandler;
import racing.io.OutputHandler;
import racing.util.CarNameParser;
import racing.util.NumberGenerator;
import racing.util.TryCountParser;

import java.util.List;

public class Racing {

    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private NumberGenerator numberGenerator;

    public Racing(InputHandler inputHandler, OutputHandler outputHandler, NumberGenerator numberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = prepareCars();
        TryCount tryCount = prepareTryCount();

        playRoundsWith(cars, tryCount);
        showFinalWinners(cars);
    }

    private Cars prepareCars() {
        outputHandler.showCarNamesRequestMessage();
        String userInput = inputHandler.getUserInput();
        List<String> carNames = CarNameParser.parse(userInput);
        return Cars.from(carNames);
    }

    private TryCount prepareTryCount() {
        outputHandler.showTryCountRequestMessage();
        String userInput = inputHandler.getUserInput();
        int count = TryCountParser.parse(userInput);
        return TryCount.from(count);
    }

    private void playRoundsWith(Cars cars, TryCount tryCount) {
        outputHandler.showRoundResultMessage();
        while (tryCount.isPlayable()) {
            cars.playSingleRound(numberGenerator);
            outputHandler.showRoundResult(cars);

            tryCount = tryCount.consume();
        }
    }

    private void showFinalWinners(Cars cars) {
        List<String> winners = cars.findWinners();
        outputHandler.showWinners(winners);
    }
}
