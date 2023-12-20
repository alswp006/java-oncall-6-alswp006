package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class DayOffCrew extends Crew{
    List<String> dayOffCrew = new ArrayList<>();
    private static final DayOffCrew DAY_OFF_CREW = new DayOffCrew();

    private DayOffCrew(){}

    public static DayOffCrew getInstance(){
        return DAY_OFF_CREW;
    }

    public void setDayOffCrew(List<String> dayOffCrew){
        this.dayOffCrew = dayOffCrew;
    }

    @Override
    protected List<String> getCrewName() {
        String crewName = this.dayOffCrew.remove(0);
        this.dayOffCrew.add(crewName);

        return dayOffCrew;
    }
}
