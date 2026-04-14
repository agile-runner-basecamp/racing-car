package racing.numberValuesGenerators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FixedNumberValuesGenerator implements NumberValuesGenerator {
    private final LinkedList<Integer> fixedNumberValues;

    private FixedNumberValuesGenerator(List<Integer> fixedNumbers) {
        validateNotBlank(fixedNumbers);
        this.fixedNumberValues = new LinkedList<>(fixedNumbers);
    }

    public static FixedNumberValuesGenerator of(List<Integer> fixedNumbers) {
        return new FixedNumberValuesGenerator(fixedNumbers);
    }

    @Override
    public List<Integer> getNumberValues(int numberCount) {
        if (fixedNumberValues.size() < numberCount) {
            throw new IllegalStateException("고정 수 배열 내 남아있는 숫자의 개수가 반환해야 할 숫자 개수보다 적습니다.");
        }
        ArrayList<Integer> outputNumberValues = new ArrayList<>();
        for (int i = 0; i < numberCount; i++) {
            outputNumberValues.add(fixedNumberValues.pollFirst());
        }
        return outputNumberValues;
    }

    private void validateNotBlank(List<Integer> fixedNumbers){
        if (fixedNumbers.isEmpty()) {
            throw new IllegalArgumentException("최소 하나 이상의 값 생성을 요청해야 합니다.");
        }
        if (fixedNumbers.contains(null)) {
            throw new IllegalArgumentException("숫자 리스트에 null이 포함될 수 없습니다.");
        }

    }


}
