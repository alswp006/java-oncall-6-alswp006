package oncall.controller;

import oncall.model.CrewRepo;
import oncall.model.DayOffCrew;
import oncall.model.WeekDayCrew;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Controller {
    InputView inputView = InputView.getInstance();
    OutputView outputView = OutputView.getInstance();

    public void run(){
        String[] monthAndWeek = inputView.inputMonthWeek();
        System.out.println(Arrays.toString(monthAndWeek));
        WeekDayCrew weekDayCrew = WeekDayCrew.getInstance();
        DayOffCrew dayOffCrew = DayOffCrew.getInstance();
        CrewRepo crewRepo = new CrewRepo(weekDayCrew, dayOffCrew);

        while(true){
            try{
                List<String> weekDayCrews = inputView.inputCrews("평일");
                List<String> dayOffCrews = inputView.inputCrews("휴일");

                weekDayCrew.setWeekDayCrews(weekDayCrews);
                dayOffCrew.setDayOffCrew(dayOffCrews);
            }catch (IllegalArgumentException ignored){}
        }

    }

}
