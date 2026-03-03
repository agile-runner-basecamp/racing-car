package racing.domain;

public class AttemptCount {
    private static final int MIN_ATTEMPT_COUNT = 1;
    private final int value;

    public AttemptCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getValue() {
        return this.value;
    }
}
