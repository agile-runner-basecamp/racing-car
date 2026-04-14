package racing.utils;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String readLine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

}
