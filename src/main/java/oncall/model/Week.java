package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week {
    List<String> weekData = Arrays.asList("월", "화", "수", "목", "금", "토", "일");


    public List<Integer> getWeekEndOfMonth(String startWeek) {
        int sundayOfMonth = weekData.size() - weekData.indexOf(startWeek);
        List<Integer> weekEndOfMonth = new ArrayList<>();

        if (sundayOfMonth == 0) {
            weekEndOfMonth.add(6);
            weekEndOfMonth.add(sundayOfMonth - 1);

            return weekEndOfMonth;
        }
        weekEndOfMonth.add(sundayOfMonth - 2);
        weekEndOfMonth.add(sundayOfMonth - 1);

        return weekEndOfMonth;
    }

    public List<String> getMonthOfWeek(String startWeek){
        List<String> monthOfWeekData = new ArrayList<>(weekData);

        while (!monthOfWeekData.get(0).equals(startWeek)){
            String temp = monthOfWeekData.remove(0);
            monthOfWeekData.add(temp);
        }

        return monthOfWeekData;
    }
}
