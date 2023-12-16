package oncall;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class InputTest extends NsTest {
    @DisplayName("배정 월, 요일 입력 예외 테스트")
    @Test
    void invalidDateTest() {
        assertSimpleTest(() -> {
            runException("0,월", "1,김민제", "13,월", ",월", "1,", ",");
            int countErrorMessage = (int) Arrays.stream(output().split("\n"))
                    .filter(s -> s.contains("[ERROR]"))
                    .count();
            assertEquals(6, countErrorMessage);
        });
    }

    @DisplayName("평일과 휴일 다른 멤버 입력에 대한 출력 확인")
    @Test
    void inputDateTest() {
        assertSimpleTest(() -> {
            run("1,월",
                    "민제,성현,정환,찬욱,민혁",
                    "민제,성현,정환,이원,민혁",
                    "민제,성현,정환,찬욱,민혁",
                    "민혁,찬욱,민제,성현,정환");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
