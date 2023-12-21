package oncall.view;

import java.util.List;

public enum OutputView {
    INSTANCE;

    public static OutputView getInstance(){
        return INSTANCE;
    }

    public void printResult(List<String> monthData, List<String> crewNames, List<Integer> weekDayDayOff){
        for (int i = 0; i < crewNames.size(); i++){
            String monthDayWeek = monthData.get(i);
            String crewData = crewNames.get(i);

            if (weekDayDayOff.contains(i+1)){
                monthDayWeek = String.format("%s%s", monthDayWeek, "(휴일)");
            }

            System.out.printf("%s %s\n", monthDayWeek, crewData);
        }
    }
}