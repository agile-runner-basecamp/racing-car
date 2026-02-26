import { InputView } from './view/InputView';
import { OutputView } from './view/OutputView';
import { Cars } from './domain/Cars/Cars';
import { RoundCount } from './domain/RoundCount/RoundCount';
import { RacingGame } from './RacingGame/RacingGame';
import { RandomMoveStrategy } from './domain/strategy/RandomMoveStrategy/RandomMoveStrategy';

export class App {
    private readonly inputView: InputView;
    private readonly outputView: OutputView;

    constructor() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    async run(): Promise<void> {
        const carNames = await this.inputView.readCarNames();
        const cars = Cars.from(carNames);

        const roundNumber = await this.inputView.readRoundCount();
        const roundCount = new RoundCount(roundNumber);

        this.outputView.printExecutionResultHeader();

        const game = new RacingGame(cars, roundCount, new RandomMoveStrategy());
        const winners = game.play(currentCars => {
            this.outputView.printRoundResult(currentCars);
        });

        this.outputView.printWinners(winners);
        this.inputView.close();
    }
}
