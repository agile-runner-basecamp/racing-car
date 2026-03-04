package racing;

public enum ErrorCode {
    CAR_NAME_LENGTH("자동차 이름은 5자를 초과할 수 없습니다."),
    CAR_NAME_DUPLICATE("자동차 이름은 중복될 수 없습니다."),
    TRY_COUNT_TYPE("시도 횟수는 숫자만 입력할 수 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
