package racing;

import racing.numberValuesGenerators.RandomNumberValuesGenerator;
import racing.utils.ConsoleInput;
import racing.utils.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        RandomNumberValuesGenerator randomNumberValuesGenerator = RandomNumberValuesGenerator.of();
        Race race = Race.of(consoleInput, consoleOutput, randomNumberValuesGenerator);
        race.run();
    }
}
