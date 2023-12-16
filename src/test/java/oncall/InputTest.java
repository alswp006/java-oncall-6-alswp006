package oncall;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
