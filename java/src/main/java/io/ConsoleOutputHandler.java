package io;

import java.util.Scanner;

public class ConsoleOutputHandler implements OutputHandler{

    @Override
    public void showGameStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Override
    public void showAttemptCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showRoundResult(){
        System.out.println("실행 결과");

    }
}
