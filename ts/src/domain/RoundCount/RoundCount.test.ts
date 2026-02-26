import { RoundCount } from './RoundCount';

describe('RoundCount', () => {
    describe('생성', () => {
        it('양의 정수로 생성할 수 있다', () => {
            const roundCount = new RoundCount(5);
            expect(roundCount.getValue()).toBe(5);
        });

        it('1로 생성할 수 있다', () => {
            const roundCount = new RoundCount(1);
            expect(roundCount.getValue()).toBe(1);
        });
    });

    describe('유효성 검증', () => {
        it('0이면 예외를 던진다', () => {
            expect(() => new RoundCount(0)).toThrow('시도 횟수는 양의 정수여야 합니다.');
        });

        it('음수이면 예외를 던진다', () => {
            expect(() => new RoundCount(-1)).toThrow('시도 횟수는 양의 정수여야 합니다.');
        });

        it('소수이면 예외를 던진다', () => {
            expect(() => new RoundCount(1.5)).toThrow('시도 횟수는 양의 정수여야 합니다.');
        });
    });
});
