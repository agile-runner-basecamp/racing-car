package racing;

import racing.io.ConsoleInputHandler;
import racing.io.ConsoleOutputHandler;
import racing.io.InputHandler;
import racing.io.OutputHandler;
import racing.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        Racing racing = new Racing(inputHandler, outputHandler, randomNumberGenerator);
        racing.run();
    }
}
