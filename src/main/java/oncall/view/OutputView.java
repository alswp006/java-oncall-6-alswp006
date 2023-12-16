package oncall.view;

import java.util.List;

public enum OutputView {

    INSTANCE;

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printResult(List<Integer> date, List<String> monthOfWeek, List<String> crewNames) {
        int month = date.get(0);
        int dayOfMonth = date.get(1);

        for (int i = 0; i < dayOfMonth; i++) {
            System.out.printf("%s월 %s일 %s %s\n", month, i + 1, monthOfWeek.get(i % 7), crewNames.get(i));
        }
    }
}
