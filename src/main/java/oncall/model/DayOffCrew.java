package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class DayOffCrew implements Crew{
    List<String> dayOffCrew = new ArrayList<>();
    private static final DayOffCrew DAY_OFF_CREW = new DayOffCrew();

    private DayOffCrew(){}

    public static DayOffCrew getInstance(){
        return DAY_OFF_CREW;
    }

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
