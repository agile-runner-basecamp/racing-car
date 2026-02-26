import { Cars } from '../domain/Cars/Cars';
import { RoundCount } from '../domain/RoundCount/RoundCount';
import { MoveStrategy } from '../domain/strategy/MoveStrategy';

export class RacingGame {
    private readonly cars: Cars;
    private readonly roundCount: RoundCount;
    private readonly strategy: MoveStrategy;

    constructor(cars: Cars, roundCount: RoundCount, strategy: MoveStrategy) {
        this.cars = cars;
        this.roundCount = roundCount;
        this.strategy = strategy;
    }

    play(onRoundEnd: (cars: Cars) => void): Cars {
        for (let i = 0; i < this.roundCount.getValue(); i++) {
            this.cars.moveAll(this.strategy);
            onRoundEnd(this.cars);
        }
        return this.cars.getWinners();
    }
}
