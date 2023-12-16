package oncall.controller;

import oncall.model.MatchCrews;
import oncall.model.Date;
import oncall.model.Week;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;

public class Controller {
    InputView inputView = InputView.getInstance();
    OutputView outputView = OutputView.getInstance();
    Week week = new Week();

    public void run(){
        String[] monthAndWeek = inputView.inputMonthWeek();
        int month = Integer.parseInt(monthAndWeek[0]);
        String startWeek = monthAndWeek[1];

        List<String> weekDayCrews = inputView.inputCrews("평일");
        List<String> dayOffCrews = inputView.inputCrews("휴일");

        int dayOfMonth = Date.getDayOfMonth(month);
        List<Integer> weekEnd = week.getWeekEndOfMonth(startWeek);
        List<Integer> dayOff = Date.getDayOffofMonth(month);

        // MatchCrews, Crews, MatchCrewsRepo 객체 생성
        MatchCrews crew = new MatchCrews(weekDayCrews, dayOffCrews);
        List<String> crews = crew.getMatchCrews(dayOfMonth, dayOff, weekEnd);
        List<String> monthOfWeekData = week.getMonthOfWeek(startWeek);

        outputView.printResult(month, dayOfMonth, monthOfWeekData, crews);
    }
}
