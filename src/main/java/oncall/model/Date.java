package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Date {
    JANUARY(1, 31, List.of(1)),
    FEBRUARY(2, 28, List.of(0)),
    MARCH(3, 31, List.of(1)),
    APRIL(4, 30, List.of(0)),
    MAY(5, 31, List.of(5)),
    JUNE(6, 30, List.of(6)),
    JULY(7, 31, List.of(0)),
    AUGUST(8, 31, List.of(15)),
    SEPTEMBER(9, 30, List.of(0)),
    OCTOBER(10, 31, List.of(3, 9)),
    NOVEMBER(11, 30, List.of(0)),
    DECEMBER(12, 31, List.of(25));

    private final int month;
    private final int day;
    private final List<Integer> dayOff;

    Date(int month, int day, List<Integer> dayOff) {
        this.month = month;
        this.day = day;
        this.dayOff = dayOff;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static int getDayOfMonth(int month) {
        Date date = Arrays.stream(Date.values())
                .filter(menus -> menus.getMonth() == (month))
                .findFirst()
                .orElseThrow();

        return date.getDay();
    }


    public static List<Integer> getDayOffofMonth(int month) {
        Date date = Arrays.stream(Date.values())
                .filter(menus -> menus.getMonth() == (month))
                .findFirst()
                .orElseThrow();
        List<Integer> dayOffOfMonth = new ArrayList<>(date.dayOff);

        if (dayOffOfMonth.get(0) == 0) {
            dayOffOfMonth.clear();
        }

        return dayOffOfMonth;
    }
}
