package io;

import racing.Car;
import racing.Cars;

import java.util.List;

public interface OutputHandler {
    public void showGameStartMessage();
    public void showAttemptCountMessage();
    public void showResultMessage();
    public void showRoundResult(Cars cars);
    public void showWinnerName(List<String> carName);
}
