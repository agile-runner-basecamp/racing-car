package racing.io;

import java.util.Scanner;

public class RaceInputReader {
    private final Scanner scanner;

    public RaceInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
