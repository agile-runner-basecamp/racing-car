package racing;

import io.InputHandler;
import io.OutputHandler;

import java.util.List;import java.util.Random;import java.util.Scanner;

public class Race {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CarFactory carFactory;
    private final Scanner scanner;


    public Race(InputHandler inputHandler, OutputHandler outputHandler, CarFactory carFactory, Scanner scanner){
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.carFactory = carFactory;
        this.scanner = scanner;
    }
    public void run(){
        outputHandler.showGameStartMessage();
        String rawNames = inputHandler.inputCarNames(scanner);

        outputHandler.showAttemptCountMessage();
        int attempts =  inputHandler.inputAttemptCounts(scanner);

        List<Car> carList = carFactory.createCars(rawNames);
        Cars cars = new Cars(carList);

        outputHandler.showResultMessage();
        for(int round = 0; round < attempts; round++){
            cars.playOneRound();
            outputHandler.showRoundResult(cars);
        }

        outputHandler.showWinnerName(cars.getWinnerList(cars));












    }
}
