import * as readline from 'readline';

export class InputView {
    private readonly rl: readline.Interface;

    constructor() {
        this.rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout,
        });
    }

    async readCarNames(): Promise<string[]> {
        const input = await this.question('경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n');
        return input.split(',');
    }

    async readRoundCount(): Promise<number> {
        const input = await this.question('시도할 회수는 몇회인가요?\n');
        return Number(input.trim());
    }

    private question(prompt: string): Promise<string> {
        return new Promise(resolve => {
            this.rl.question(prompt, answer => resolve(answer));
        });
    }

    close(): void {
        this.rl.close();
    }
}
