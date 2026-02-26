export class Position {
    private readonly value: number;

    constructor(value: number = 0) {
        this.value = value;
    }

    advance(): Position {
        return new Position(this.value + 1);
    }

    getValue(): number {
        return this.value;
    }

    equals(other: Position): boolean {
        return this.value === other.value;
    }
}
