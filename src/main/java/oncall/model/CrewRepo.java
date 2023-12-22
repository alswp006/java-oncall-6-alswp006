package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class CrewRepo {
    Crew crew;
    WeekDayCrew weekDayCrew;
    DayOffCrew dayOffCrew;

    public CrewRepo(WeekDayCrew weekDayCrew, DayOffCrew dayOffCrew) {
        this.weekDayCrew = weekDayCrew;
        this.dayOffCrew = dayOffCrew;
    }

    public List<String> getTotalCrewNames(List<Integer> weekEnd, List<Integer> dayOff, int day) {
        List<String> totalCrewNames = new ArrayList<>();
        crew = weekDayCrew;

        for (int i = 1; i < day + 1; i++) {
            if (weekEnd.contains(i) || dayOff.contains(i)) {
                crew = dayOffCrew;
            }
            totalCrewNames.add(crew.getCrewName());
            crew = weekDayCrew;
        }

        totalCrewNames = changeContinuousWork(totalCrewNames);

        return totalCrewNames;
    }

    private List<String> changeContinuousWork(List<String> totalCrewNames) {
        int i = 1;

        while (i < totalCrewNames.size()) {
            if (totalCrewNames.get(i).equals(totalCrewNames.get(i - 1))) {
                String temp = totalCrewNames.get(i);
                totalCrewNames.set(i, totalCrewNames.get(i + 1));
                totalCrewNames.set(i + 1, temp);
                i = 1;
            }
            i++;
        }

        return totalCrewNames;
    }
}
