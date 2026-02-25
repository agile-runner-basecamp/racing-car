package racing;

import io.InputHandler;
import io.OutputHandler;

import java.util.Scanner;

public class Race {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CarFactory carFactory;


    public Race(InputHandler inputHandler, OutputHandler outputHandler, CarFactory carFactory){
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.carFactory = carFactory;
    }
    public void run(){
        outputHandler.showGameStartMessage();
        String rawNames = inputHandler.inputCarNames();

        outputHandler.showAttemptCountMessage();
        int attempts =  inputHandler.inputAttemptCounts();

        Cars cars = new Cars(carFactory.createCars(rawNames));





    }
}
