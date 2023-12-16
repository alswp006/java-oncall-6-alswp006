package oncall.controller;

import oncall.view.InputView;

import java.util.List;

public class Controller {
    InputView inputView = InputView.getInstance();

    public void run(){
        String[] monthAndWeek = inputView.inputMonthWeek();
        int month = Integer.parseInt(monthAndWeek[0]);
        String week = monthAndWeek[1];

        List<String> weekDayCrews = inputView.inputCrews("평일");
        List<String> dayOffCrews = inputView.inputCrews("휴일");
    }
}
