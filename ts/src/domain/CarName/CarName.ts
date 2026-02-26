export class CarName {
    private static readonly MAX_LENGTH = 5;
    private readonly value: string;

    constructor(value: string) {
        this.validate(value);
        this.value = value;
    }

    private validate(value: string): void {
        if (value.trim().length === 0) {
            throw new Error('자동차 이름은 빈 문자열일 수 없습니다.');
        }
        if (value.length > CarName.MAX_LENGTH) {
            throw new Error(`자동차 이름은 ${CarName.MAX_LENGTH}자를 초과할 수 없습니다.`);
        }
    }

    getValue(): string {
        return this.value;
    }
}
