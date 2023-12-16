package oncall.view;

import java.util.List;

public enum OutputView {

    INSTANCE;

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printResult(int month, int day, List<String> monthOfWeek, List<String> crewNames) {

        for (int i = 0; i < day; i++) {
            System.out.printf("%s월 %s일 %s %s\n", month, i + 1, monthOfWeek.get(i % 7), crewNames.get(i));
        }
    }
}
