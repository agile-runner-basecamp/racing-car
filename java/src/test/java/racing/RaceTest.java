package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RaceTest {

    @DisplayName("전체 게임 흐름이 정상 동작한다")
    @Test
    void runFullGame() throws IOException {
        // 테스트 환경에서는 실제 키보드 입력과 화면 출력을 사용할 수 없으므로,
        // 어쩔 수 없이 "키보드/화면"을 "문자열 변수"로 갈아끼워서
        // 입력은 미리 만든 문자열에서 읽고, 출력은 버퍼에 캡처해 검증한다.

        String input = "kim,lee\n3\n"; // 자동차 이름, 라운드 수
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Race race = new Race(new FixedMovingStrategy(4), new InputHandler(), new OutputHandler());
        race.run();

        String output = out.toString();

        // 라운드별 결과 검증 (FixedMovingStrategy(4)이므로 매 라운드 모두 전진)
        assertThat(output).contains("kim : -");
        assertThat(output).contains("lee : -");
        assertThat(output).contains("kim : --");
        assertThat(output).contains("lee : --");
        assertThat(output).contains("kim : ---");
        assertThat(output).contains("lee : ---");

        // 최종 우승자 검증
        assertThat(output).contains("kim, lee가 최종 우승했습니다.");
    }
}
