package oncall.model;

public class CrewRepo {
    Crew crew;
    WeekDayCrew weekDayCrew;
    DayOffCrew dayOffCrew;

    public CrewRepo(WeekDayCrew weekDayCrew, DayOffCrew dayOffCrew){
        this.weekDayCrew = weekDayCrew;
        this.dayOffCrew = dayOffCrew;
    }

}
