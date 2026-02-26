import { RacingGame } from './RacingGame';
import { Cars } from '../domain/Cars/Cars';
import { RoundCount } from '../domain/RoundCount/RoundCount';
import { MoveStrategy } from '../domain/strategy/MoveStrategy';

const alwaysMove: MoveStrategy = { canMove: () => true };
const neverMove: MoveStrategy = { canMove: () => false };

describe('RacingGame', () => {
    describe('play', () => {
        it('지정된 라운드 수만큼 진행한다', () => {
            const cars = Cars.from(['kim', 'lee']);
            const game = new RacingGame(cars, new RoundCount(3), alwaysMove);
            let roundCount = 0;

            game.play(() => { roundCount++; });

            expect(roundCount).toBe(3);
        });

        it('매 라운드마다 콜백이 호출된다', () => {
            const cars = Cars.from(['kim']);
            const game = new RacingGame(cars, new RoundCount(2), alwaysMove);
            const snapshots: number[] = [];

            game.play((currentCars) => {
                snapshots.push(currentCars.getCars()[0].getPosition().getValue());
            });

            expect(snapshots).toEqual([1, 2]);
        });

        it('모든 차가 이동하면 각 차의 위치가 라운드 수와 같다', () => {
            const cars = Cars.from(['kim', 'lee']);
            const game = new RacingGame(cars, new RoundCount(3), alwaysMove);

            game.play(() => {});

            cars.getCars().forEach(car => {
                expect(car.getPosition().getValue()).toBe(3);
            });
        });

        it('우승자를 반환한다', () => {
            const cars = Cars.from(['kim', 'lee']);
            let callCount = 0;
            const partialMove: MoveStrategy = {
                canMove: () => {
                    callCount++;
                    return callCount % 2 === 1;
                }
            };
            const game = new RacingGame(cars, new RoundCount(1), partialMove);

            const winners = game.play(() => {});

            expect(winners.getNames()).toEqual(['kim']);
        });

        it('아무도 이동하지 않으면 모두 우승자다', () => {
            const cars = Cars.from(['kim', 'lee']);
            const game = new RacingGame(cars, new RoundCount(1), neverMove);

            const winners = game.play(() => {});

            expect(winners.getNames()).toEqual(['kim', 'lee']);
        });
    });
});
