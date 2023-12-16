package oncall.model;

import oncall.util.Error;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static void checkEqualsList(List<String> list1, List<String> list2){
        if (!new HashSet<>(list1).equals(new HashSet<>(list2))){
            Error.throwError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
