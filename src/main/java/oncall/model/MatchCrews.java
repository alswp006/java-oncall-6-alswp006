package oncall.model;

import java.util.List;

public class MatchCrews {
    MatchCrewsRepo matchCrews;
    Crews weekDayCrews;
    Crews dayOffCrews;

    public MatchCrews(Crews weekDayCrews, Crews dayOffCrews){
        this.matchCrews = new MatchCrewsRepo();
        this.weekDayCrews = weekDayCrews;
        this.dayOffCrews = dayOffCrews;
    }

    public List<String> getMatchCrews(int dayOfMonth, List<Integer> dayOff, List<Integer> weekEnd){
        for (int i = 0; i < dayOfMonth; i++){
            if (dayOff.contains(i + 1) || weekEnd.contains(i%7)){
                matchCrews.add(dayOffCrews.rotateCrews());
                continue;
            }
            matchCrews.add(weekDayCrews.rotateCrews());
        }

        return matchCrews.getMatchCrews();
    }
}
