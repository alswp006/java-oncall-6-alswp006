package oncall.controller;

import oncall.model.*;
import oncall.view.InputView;
import oncall.view.OutputView;
import java.util.List;

public class Controller {
    InputView inputView = InputView.getInstance();
    OutputView outputView = OutputView.getInstance();

    public void run(){
        Week weekData = new Week();
        WeekDayCrew weekDayCrew = new WeekDayCrew();
        DayOffCrew dayOffCrew = new DayOffCrew();
        CrewRepo crewRepo = new CrewRepo(weekDayCrew, dayOffCrew);
        String[] monthAndWeek = inputView.inputMonthWeek();
        setCrews(weekDayCrew, dayOffCrew);

        int month = Integer.parseInt(monthAndWeek[0]);
        String startWeek = monthAndWeek[1];
        int dayOfMonth = Date.getDayOfMonth(month);
        List<Integer> weekEnd = weekData.getWeekEndOfMonth(startWeek, dayOfMonth);
        List<Integer> dayOff = Date.getDayOffofMonth(month, weekEnd);
        List<String> crewNames = crewRepo.getTotalCrewNames(weekEnd, dayOff, dayOfMonth);
        List<String> weeks = weekData.getMonthData(month, dayOfMonth, startWeek);

        outputView.printResult(weeks, crewNames, dayOff);
    }

    private void setCrews(WeekDayCrew weekDayCrew, DayOffCrew dayOffCrew){
        while(true){
            try{
                List<String> weekDayCrews = inputView.inputCrews("평일");
                List<String> dayOffCrews = inputView.inputCrews("휴일");

                weekDayCrew.setWeekDayCrews(weekDayCrews);
                dayOffCrew.setDayOffCrew(dayOffCrews);
                break;
            }catch (IllegalArgumentException ignored){}
        }
    }
}
