import { CarName } from '../CarName/CarName';
import { Position } from '../Position/Position';
import { MoveStrategy } from '../strategy/MoveStrategy';

export class Car {
    private readonly name: CarName;
    private position: Position;

    constructor(name: CarName) {
        this.name = name;
        this.position = new Position();
    }

    move(strategy: MoveStrategy): void {
        if (strategy.canMove()) {
            this.position = this.position.advance();
        }
    }

    getName(): CarName {
        return this.name;
    }

    getPosition(): Position {
        return this.position;
    }
}
