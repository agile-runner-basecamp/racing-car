import { Car } from '../Car/Car';
import { CarName } from '../CarName/CarName';
import { Position } from '../Position/Position';
import { MoveStrategy } from '../strategy/MoveStrategy';

export class Cars {
    private readonly cars: Car[];

    constructor(cars: Car[]) {
        this.cars = cars;
    }

    static from(names: string[]): Cars {
        const cars = names.map(name => new Car(new CarName(name.trim())));
        return new Cars(cars);
    }

    moveAll(strategy: MoveStrategy): void {
        this.cars.forEach(car => car.move(strategy));
    }

    getWinners(): Cars {
        const maxPosition = this.findMaxPosition();
        const winners = this.cars.filter(car => car.getPosition().equals(maxPosition));
        return new Cars(winners);
    }

    private findMaxPosition(): Position {
        const maxValue = Math.max(...this.cars.map(car => car.getPosition().getValue()));
        return new Position(maxValue);
    }

    getCars(): Car[] {
        return [...this.cars];
    }

    getNames(): string[] {
        return this.cars.map(car => car.getName().getValue());
    }
}
