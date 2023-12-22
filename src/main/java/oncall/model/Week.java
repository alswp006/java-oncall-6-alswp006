package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week {
    List<String> weekData = Arrays.asList("월", "화", "수", "목", "금", "토", "일");

    public List<Integer> getWeekEndOfMonth(String startWeek, int day) {
        List<Integer> weekends = new ArrayList<>();
        int offset = (5 - weekData.indexOf(startWeek)) % 7 + 1;

        for (int i = offset; i <= day; i += 7) {
            weekends.add(i);
            if (i + 1 <= day) {
                weekends.add(i + 1);
            }
        }

        return weekends;
    }

    public List<String> getMonthData(int month, int day, String startWeek){
        List<String> monthWeek = getMonthOfWeek(startWeek);
        List<String> monthData = new ArrayList<>();

        for (int i = 1; i < day+1; i++){
            String temp = String.format("%s월 %s일 %s",month, i, monthWeek.get((i-1) % 7));
            monthData.add(temp);
        }

        return monthData;
    }

    private List<String> getMonthOfWeek(String startWeek) {
        List<String> monthOfWeekData = new ArrayList<>(weekData);

        while (!monthOfWeekData.get(0).equals(startWeek)) {
            String temp = monthOfWeekData.remove(0);
            monthOfWeekData.add(temp);
        }

        return monthOfWeekData;
    }
}