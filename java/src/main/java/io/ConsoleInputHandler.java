package io;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler{
    public final Scanner scanner;

    public ConsoleInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String inputCarNames(Scanner scanner){
        return scanner.nextLine();
    }

    @Override
    public int inputAttemptCounts(Scanner scanner){
        return scanner.nextInt();
    }
}
