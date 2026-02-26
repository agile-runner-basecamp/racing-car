import { Cars } from './Cars';
import { MoveStrategy } from '../strategy/MoveStrategy';

const alwaysMove: MoveStrategy = { canMove: () => true };
const neverMove: MoveStrategy = { canMove: () => false };

describe('Cars', () => {
    describe('from', () => {
        it('이름 배열로 Cars를 생성한다', () => {
            const cars = Cars.from(['kim', 'lee', 'park']);
            expect(cars.getNames()).toEqual(['kim', 'lee', 'park']);
        });

        it('이름에 공백이 있으면 trim한다', () => {
            const cars = Cars.from([' kim ', ' lee ']);
            expect(cars.getNames()).toEqual(['kim', 'lee']);
        });

        it('이름이 5자를 초과하면 예외를 던진다', () => {
            expect(() => Cars.from(['toolongname'])).toThrow('5자를 초과할 수 없습니다');
        });
    });

    describe('moveAll', () => {
        it('모든 자동차가 이동 가능하면 모두 위치가 1 증가한다', () => {
            const cars = Cars.from(['kim', 'lee']);
            cars.moveAll(alwaysMove);
            cars.getCars().forEach(car => {
                expect(car.getPosition().getValue()).toBe(1);
            });
        });

        it('모든 자동차가 이동 불가능하면 위치가 변하지 않는다', () => {
            const cars = Cars.from(['kim', 'lee']);
            cars.moveAll(neverMove);
            cars.getCars().forEach(car => {
                expect(car.getPosition().getValue()).toBe(0);
            });
        });
    });

    describe('getWinners', () => {
        it('가장 멀리 이동한 자동차를 반환한다', () => {
            const cars = Cars.from(['kim', 'lee', 'park']);
            const [kim, lee] = cars.getCars();
            kim.move(alwaysMove);
            kim.move(alwaysMove);
            lee.move(alwaysMove);

            const winners = cars.getWinners();
            expect(winners.getNames()).toEqual(['kim']);
        });

        it('공동 우승자가 있으면 모두 반환한다', () => {
            const cars = Cars.from(['kim', 'lee', 'park']);
            const [kim, , park] = cars.getCars();
            kim.move(alwaysMove);
            kim.move(alwaysMove);
            park.move(alwaysMove);
            park.move(alwaysMove);

            const winners = cars.getWinners();
            expect(winners.getNames()).toEqual(['kim', 'park']);
        });

        it('아무도 이동하지 않으면 모두 우승자다', () => {
            const cars = Cars.from(['kim', 'lee']);
            const winners = cars.getWinners();
            expect(winners.getNames()).toEqual(['kim', 'lee']);
        });
    });
});
