package oncall.controller;

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
        List<String> weekDayCrews;
        List<String> dayOffCrews;

        while(true){
            try{
                weekDayCrews = inputView.inputCrews("평일");
                dayOffCrews = inputView.inputCrews("휴일");
                System.out.println(weekDayCrews);
                System.out.println(dayOffCrews);
            }catch (IllegalArgumentException ignored){}
        }

    }

}
