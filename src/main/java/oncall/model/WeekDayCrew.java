package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class WeekDayCrew implements Crew{
    private List<String> weekDayCrews = new ArrayList<>();

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
