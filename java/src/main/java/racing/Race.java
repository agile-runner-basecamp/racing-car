package racing;

import racing.numberValuesGenerators.NumberValuesGenerator;
import racing.utils.ConsoleInput;
import racing.utils.ConsoleOutput;
import racing.utils.Parser;

import java.util.List;

public class Race {

    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final NumberValuesGenerator numberValuesGenerator;

    private Race(ConsoleInput consoleInput, ConsoleOutput consoleOutput, NumberValuesGenerator numberValuesGenerator) {

        validateNotBlank(consoleInput, consoleOutput, numberValuesGenerator);
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.numberValuesGenerator = numberValuesGenerator;
    }

    public static Race of(ConsoleInput consoleInput, ConsoleOutput consoleOutput, NumberValuesGenerator numberValuesGenerator) {
        return new Race(consoleInput, consoleOutput, numberValuesGenerator);
    }

    public void run(){

        String inputNames = consoleInput.readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Cars cars = Cars.of(inputNames);
        int carSize = cars.getSize();

        int roundCount = Parser.parseInt(consoleInput.readLine("시도할 횟수는 몇 회인가요?"));

        consoleOutput.println("실행 결과");
        for (int i = 0; i < roundCount; i++) {
            List<Integer> randomValues = numberValuesGenerator.getNumberValues(carSize);
            cars.moveAll(randomValues);
            consoleOutput.printlnAll(cars.getPositionViews());
        }

        List<String> winners = cars.getWinnerNames();
        consoleOutput.println( String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private void validateNotBlank(ConsoleInput consoleInput, ConsoleOutput consoleOutput, NumberValuesGenerator numberValuesGenerator) {
        if (consoleInput==null){
            throw new IllegalArgumentException("콘솔 입력 구현체를 지정해야 합니다.");
        }
        if (consoleOutput==null){
            throw new IllegalArgumentException("콘솔 출력 구현체를 지정해야 합니다.");
        }
        if (numberValuesGenerator==null){
            throw new IllegalArgumentException("숫자 생성기 구현체를 지정해야 합니다.");
        }
    }
}
