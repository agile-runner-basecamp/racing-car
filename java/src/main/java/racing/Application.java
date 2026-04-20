package racing;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        Race race = new Race(randomMovingStrategy, inputHandler, outputHandler);
        race.run();
    }
}
