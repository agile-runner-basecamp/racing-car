import { MoveStrategy } from '../MoveStrategy';

export class RandomMoveStrategy implements MoveStrategy {
    private static readonly MOVE_THRESHOLD = 4;
    private static readonly RANDOM_RANGE = 10;

    canMove(): boolean {
        const randomValue = Math.floor(Math.random() * RandomMoveStrategy.RANDOM_RANGE);
        return randomValue >= RandomMoveStrategy.MOVE_THRESHOLD;
    }
}
