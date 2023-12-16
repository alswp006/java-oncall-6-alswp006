package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class MatchCrewsRepo {
    private final List<String> matchCrews = new ArrayList<>();

    MatchCrewsRepo(){
    }

    public void add(String crew){
        this.matchCrews.add(crew);
    }

    private void changeContinuousNumber(){
        for (int i = 1; i < matchCrews.size() - 1; i++) {
            if (matchCrews.get(i).equals(matchCrews.get(i - 1))) {
                String temp = matchCrews.get(i);
                matchCrews.set(i, matchCrews.get(i + 1));
                matchCrews.set(i + 1, temp);
            }
        }
    }

    public List<String> getMatchCrews(){
        changeContinuousNumber();

        return matchCrews;
    }

}