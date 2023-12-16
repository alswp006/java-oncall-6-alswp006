package oncall.controller;

import oncall.model.*;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Controller {
    InputView inputView = InputView.getInstance();
    OutputView outputView = OutputView.getInstance();
    Week week = new Week();

    public void run(){
        String[] monthAndWeek = inputView.inputMonthWeek();
        int month = Integer.parseInt(monthAndWeek[0]);
        int dayOfMonth = Date.getDayOfMonth(month);
        String startWeek = monthAndWeek[1];
        List<Integer> weekEnd = week.getWeekEndOfMonth(startWeek);
        List<Integer> dayOff = Date.getDayOffofMonth(month);

        MatchCrews crew = inputMatchCrews();
        List<String> crews = crew.getMatchCrews(dayOfMonth, dayOff, weekEnd);
        List<String> monthOfWeekData = week.getMonthOfWeek(startWeek);

        List<Integer> date = Arrays.asList(month, dayOfMonth);
        outputView.printResult(date, monthOfWeekData, crews);
    }

    private MatchCrews inputMatchCrews(){
        while(true){
            try{
                List<String> weekDayCrews = inputView.inputCrews("평일");
                List<String> dayOffCrews = inputView.inputCrews("휴일");

                Validator.checkEqualsList(weekDayCrews, dayOffCrews);

                return new MatchCrews(new Crews(weekDayCrews), new Crews(dayOffCrews));
            }catch (IllegalArgumentException ignored){}
        }
    }
}
