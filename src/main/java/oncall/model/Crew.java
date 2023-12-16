package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    List<String> matchCrews = new ArrayList<>();
    List<String> weekDayCrews = new ArrayList<>();
    List<String> dayOffCrews = new ArrayList<>();

    public Crew(List<String> weekDayCrews, List<String> dayOffCrews){
        this.weekDayCrews.addAll(weekDayCrews);
        this.dayOffCrews.addAll(dayOffCrews);
    }

    public void matchCrew(int dayOfMonth, List<Integer> dayOff, List<Integer> weekEnd){
        String crewName;

        for (int i = 0; i < dayOfMonth; i++){
            if (dayOff.contains(i + 1) || weekEnd.contains(i%7)){
                crewName = getDayOffCrew();
                matchCrews.add(crewName);
                continue;
            }
            crewName = getWeekDayCrew();
            matchCrews.add(crewName);
        }
        changeContinuousNumber();
    }

    public String getDayOffCrew(){
        String crewName = dayOffCrews.remove(0);
        rotateDayOffCrews(crewName);

        return crewName;
    }

    public void rotateDayOffCrews(String crewName){
        dayOffCrews.add(crewName);
    }
    public String getWeekDayCrew(){
        String crewName = weekDayCrews.remove(0);
        rotateWeekDayCrews(crewName);

        return crewName;
    }

    public void rotateWeekDayCrews(String crewName){
        weekDayCrews.add(crewName);
    }

    public List<String> getMatchCrews(){
        return matchCrews;
    }

    public void changeContinuousNumber(){
        for (int i = 1; i < matchCrews.size() - 1; i++) {
            if (matchCrews.get(i).equals(matchCrews.get(i - 1))) {
                String temp = matchCrews.get(i);
                matchCrews.set(i, matchCrews.get(i + 1));
                matchCrews.set(i + 1, temp);
            }
        }
    }
}
