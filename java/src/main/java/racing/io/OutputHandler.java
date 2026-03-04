package racing.io;

import racing.domain.Cars;

import java.util.List;
import java.util.Map;

public interface OutputHandler {
    void showCarNamesRequestMessage();

    void showTryCountRequestMessage();

    void showRoundResultMessage();

    void showRoundResult(Cars cars);

    void showWinners(List<String> winners);
}
