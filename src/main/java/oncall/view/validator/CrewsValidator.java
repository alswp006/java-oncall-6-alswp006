package oncall.view.validator;

import oncall.util.Error;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrewsValidator implements Validator{
    private static final CrewsValidator CREWS_VALIDATOR = new CrewsValidator();
    private final int MIN_CREW_RANGE = 5;
    private final int MAX_CREW_RANGE = 35;
    private final int MAX_CREW_NAME_RANGE = 5;

    private CrewsValidator() {
    }
    public static CrewsValidator getInstance(){return CREWS_VALIDATOR;}


    @Override
    public void validate(String input) {
        List<String> crewsName = Arrays.asList(input.split(","));

        checkCrewsNumber(crewsName);
        checkEmptyName(crewsName);
        checkCrewsNameRange(crewsName);
        checkDuplicateName(crewsName);
    }

    private void checkCrewsNumber(List<String> crewsName){

        if (crewsName.size() < MIN_CREW_RANGE || crewsName.size() > MAX_CREW_RANGE){
            Error.throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void checkEmptyName(List<String> crewsName){
        crewsName.forEach(name -> {
            if (name.isEmpty()){
                Error.throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        });
    }
    private void checkCrewsNameRange(List<String> crewsName){
        crewsName.forEach(name -> {
            if (name.length() > MAX_CREW_NAME_RANGE){
                Error.throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        });
    }

    private void checkDuplicateName(List<String> crewsName){
        Set<String> notDuplicateCrewsName = new HashSet<>(crewsName);

        if (crewsName.size() != notDuplicateCrewsName.size()){
            Error.throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
