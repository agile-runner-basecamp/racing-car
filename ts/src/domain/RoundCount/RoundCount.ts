export class RoundCount {
    private readonly value: number;

    constructor(value: number) {
        this.validate(value);
        this.value = value;
    }

    private validate(value: number): void {
        if (!Number.isInteger(value) || value <= 0) {
            throw new Error('시도 횟수는 양의 정수여야 합니다.');
        }
    }

    getValue(): number {
        return this.value;
    }
}
