import { CarName } from './CarName';

describe('CarName', () => {
    describe('생성', () => {
        it('유효한 이름으로 생성할 수 있다', () => {
            const carName = new CarName('kim');
            expect(carName.getValue()).toBe('kim');
        });

        it('5자 이름으로 생성할 수 있다', () => {
            const carName = new CarName('abcde');
            expect(carName.getValue()).toBe('abcde');
        });
    });

    describe('유효성 검증', () => {
        it('이름이 5자를 초과하면 예외를 던진다', () => {
            expect(() => new CarName('abcdef')).toThrow('자동차 이름은 5자를 초과할 수 없습니다.');
        });

        it('이름이 빈 문자열이면 예외를 던진다', () => {
            expect(() => new CarName('')).toThrow('자동차 이름은 빈 문자열일 수 없습니다.');
        });

        it('이름이 공백만 있으면 예외를 던진다', () => {
            expect(() => new CarName('   ')).toThrow('자동차 이름은 빈 문자열일 수 없습니다.');
        });
    });

    describe('getValue', () => {
        it('설정한 이름 값을 반환한다', () => {
            const carName = new CarName('park');
            expect(carName.getValue()).toBe('park');
        });
    });
});
