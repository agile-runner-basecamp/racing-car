import { Position } from './Position';

describe('Position', () => {
    describe('생성', () => {
        it('초기 위치는 0이다', () => {
            const position = new Position();
            expect(position.getValue()).toBe(0);
        });

        it('특정 값으로 생성할 수 있다', () => {
            const position = new Position(3);
            expect(position.getValue()).toBe(3);
        });
    });

    describe('advance', () => {
        it('advance 호출 시 위치가 1 증가한 새 Position을 반환한다', () => {
            const position = new Position(2);
            const advanced = position.advance();
            expect(advanced.getValue()).toBe(3);
        });

        it('원본 Position은 변경되지 않는다', () => {
            const position = new Position(2);
            position.advance();
            expect(position.getValue()).toBe(2);
        });
    });

    describe('equals', () => {
        it('같은 값의 Position은 동등하다', () => {
            const a = new Position(3);
            const b = new Position(3);
            expect(a.equals(b)).toBe(true);
        });

        it('다른 값의 Position은 동등하지 않다', () => {
            const a = new Position(3);
            const b = new Position(4);
            expect(a.equals(b)).toBe(false);
        });
    });
});
