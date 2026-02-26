import { Cars } from '../domain/Cars/Cars';

export class OutputView {
    printExecutionResultHeader(): void {
        console.log('\n실행 결과');
    }

    printRoundResult(cars: Cars): void {
        cars.getCars().forEach(car => {
            const name = car.getName().getValue();
            const position = '-'.repeat(car.getPosition().getValue());
            console.log(`${name} : ${position}`);
        });
        console.log('');
    }

    printWinners(winners: Cars): void {
        const winnerNames = winners.getNames().join(', ');
        console.log(`${winnerNames}가 최종 우승했습니다.`);
    }
}
