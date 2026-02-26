import { RandomMoveStrategy } from './RandomMoveStrategy';

describe('RandomMoveStrategy', () => {
    afterEach(() => {
        jest.restoreAllMocks();
    });

    describe('canMove', () => {
        it('random 값이 4 이상이면 true를 반환한다', () => {
            jest.spyOn(Math, 'random').mockReturnValue(0.4);
            const strategy = new RandomMoveStrategy();
            expect(strategy.canMove()).toBe(true);
        });

        it('random 값이 9이면 true를 반환한다', () => {
            jest.spyOn(Math, 'random').mockReturnValue(0.99);
            const strategy = new RandomMoveStrategy();
            expect(strategy.canMove()).toBe(true);
        });

        it('random 값이 3이면 false를 반환한다', () => {
            jest.spyOn(Math, 'random').mockReturnValue(0.39);
            const strategy = new RandomMoveStrategy();
            expect(strategy.canMove()).toBe(false);
        });

        it('random 값이 0이면 false를 반환한다', () => {
            jest.spyOn(Math, 'random').mockReturnValue(0);
            const strategy = new RandomMoveStrategy();
            expect(strategy.canMove()).toBe(false);
        });
    });
});
