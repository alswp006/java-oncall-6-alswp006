package oncall.model;


import java.util.ArrayList;
import java.util.List;

public class Crews {
    private List<String> crews;

    public Crews(List<String> crews){
        this.crews = new ArrayList<>(crews);
    }

    public String rotateCrews(){
        String crewName = this.crews.remove(0);
        this.crews.add(crewName);

        return crewName;
    }

    public int size(){
        return this.crews.size();
    }
}
