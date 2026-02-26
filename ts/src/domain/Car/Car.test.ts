import { Car } from './Car';
import { CarName } from '../CarName/CarName';
import { MoveStrategy } from '../strategy/MoveStrategy';

const alwaysMove: MoveStrategy = { canMove: () => true };
const neverMove: MoveStrategy = { canMove: () => false };

describe('Car', () => {
    describe('생성', () => {
        it('초기 위치는 0이다', () => {
            const car = new Car(new CarName('kim'));
            expect(car.getPosition().getValue()).toBe(0);
        });

        it('이름을 가진다', () => {
            const car = new Car(new CarName('lee'));
            expect(car.getName().getValue()).toBe('lee');
        });
    });

    describe('move', () => {
        it('전략이 이동 가능하면 위치가 1 증가한다', () => {
            const car = new Car(new CarName('kim'));
            car.move(alwaysMove);
            expect(car.getPosition().getValue()).toBe(1);
        });

        it('전략이 이동 불가능하면 위치가 변하지 않는다', () => {
            const car = new Car(new CarName('kim'));
            car.move(neverMove);
            expect(car.getPosition().getValue()).toBe(0);
        });

        it('여러 번 이동하면 위치가 누적된다', () => {
            const car = new Car(new CarName('kim'));
            car.move(alwaysMove);
            car.move(alwaysMove);
            car.move(alwaysMove);
            expect(car.getPosition().getValue()).toBe(3);
        });
    });
});
