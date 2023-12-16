package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.view.validator.CrewsValidator;
import oncall.view.validator.MonthAndWeekValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InputView {
    INSTANCE;

    public static InputView getInstance(){
        return INSTANCE;
    }

    public String[] inputMonthWeek(){
        MonthAndWeekValidator validator = MonthAndWeekValidator.getInstance();
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Console.readLine();

        validator.validate(input);

        return input.split(",");
    }

    public List<String> inputCrews(String week){
        CrewsValidator validator = CrewsValidator.getInstance();
        System.out.printf("%s 비상 근무 순번대로 사원 닉네임을 입력하세요> ", week);
        String input = Console.readLine();

        validator.validate(input);

        return Arrays.stream(input.split(",")).toList();
    }
}
