package racing;


import io.ConsoleInputHandler;import io.ConsoleOutputHandler;import io.InputHandler;import io.OutputHandler;import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
       InputHandler inputHandler = new ConsoleInputHandler(new Scanner(System.in));
       OutputHandler outputHandler = new ConsoleOutputHandler();
       CarFactory carFactory = new CarFactory();

        Race race = new Race(inputHandler, outputHandler, carFactory, new Scanner(System.in));
        race.run();


    }
}
