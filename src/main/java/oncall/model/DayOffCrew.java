package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class DayOffCrew implements Crew{
    List<String> dayOffCrew = new ArrayList<>();

    public void setDayOffCrew(List<String> dayOffCrew){
        this.dayOffCrew.addAll(dayOffCrew);
    }

    @Override
    public String getCrewName() {
        String crewName = this.dayOffCrew.remove(0);
        this.dayOffCrew.add(crewName);

        return crewName;
    }
}
