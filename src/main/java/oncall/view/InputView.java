package oncall.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InputView {
    INSTANCE;

    public static InputView getInstance(){
        return INSTANCE;
    }

    public String inputMonthWeek(){
        String input = Console.readLine();

        return input;
    }

    public List<String> inputCrews(){
        String input = Console.readLine();

        return Arrays.stream(input.split(",")).toList();
    }
}
