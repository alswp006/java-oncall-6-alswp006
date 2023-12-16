package oncall.controller;

import oncall.model.Crew;
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

        Crew crew = new Crew(weekDayCrews, dayOffCrews);
        crew.matchCrew(dayOfMonth, dayOff, weekEnd);
        List<String> crews = crew.getMatchCrews();
        List<String> monthOfWeekData = week.getMonthOfWeek(startWeek);
        System.out.println(monthOfWeekData);

        outputView.printResult(month, dayOfMonth, monthOfWeekData, crews);
    }
}
