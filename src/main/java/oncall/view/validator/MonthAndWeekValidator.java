package oncall.view.validator;

import java.util.Arrays;
import java.util.List;

public class MonthAndWeekValidator extends Validator {
    private static final MonthAndWeekValidator MONTH_AND_WEEK_VALIDATOR = new MonthAndWeekValidator();

    private MonthAndWeekValidator() {
    }

    public static MonthAndWeekValidator getInstance() {
        return MONTH_AND_WEEK_VALIDATOR;
    }

    List<String> weekData = Arrays.asList("월", "화", "수", "목", "금", "토", "일");

    @Override
    public void validate(String input) {
        checkInputSize(input);

        String[] monthAndWeek = input.split(",");
        String month = monthAndWeek[0];
        String week = monthAndWeek[1];

        checkMonth(month);
        checkWeek(week);
    }

    private void checkInputSize(String input){
        if (Arrays.stream(input.split(",")).toList().size() != 2){
            throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void checkMonth(String month) {
        checkMonthType(month);
        checkMonthRange(month);
    }

    private void checkWeek(String week) {
        checkWeekData(week);
    }

    private void checkMonthType(String month) {
        try {
            Integer.parseInt(month);
        } catch (NumberFormatException e) {
            throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void checkMonthRange(String month) {
        int monthData = Integer.parseInt(month);

        if (monthData < 1 || monthData > 12) {
            throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void checkWeekData(String week) {
        if (!weekData.contains(week)) {
            throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

}