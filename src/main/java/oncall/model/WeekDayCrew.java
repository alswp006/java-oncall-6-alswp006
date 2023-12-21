package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class WeekDayCrew extends Crew{
    private List<String> weekDayCrews = new ArrayList<>();
    private static final WeekDayCrew WEEK_DAY_CREW = new WeekDayCrew();
    private WeekDayCrew(){}

    public static WeekDayCrew getInstance(){
        return WEEK_DAY_CREW;
    }

    public void setWeekDayCrews(List<String> weekDayCrews){
        this.weekDayCrews.addAll(weekDayCrews);
    }

    @Override
    public String getCrewName() {
        String crewName = this.weekDayCrews.remove(0);
        this.weekDayCrews.add(crewName);

        return crewName;
    }
}
