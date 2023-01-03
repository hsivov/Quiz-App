package quiz.io;

import quiz.entity.Question;
import quiz.repository.Repository;

import java.util.Map;

public class Printer {

    public static void printMenu() {
        System.out.println("Choose option:" +
                System.lineSeparator() + "1. Start Test" +
                System.lineSeparator() + "2. Add Question" +
                System.lineSeparator() + "3. Delete Question" +
                System.lineSeparator() + "4. Exit");
    }

    public static String printResult(int correctAnswers, int totalQuestions) {
        return String.format("You have answered correctly at %d of %d questions.%n", correctAnswers, totalQuestions);
    }

    public static void printAll(Repository questions) {

        String lineSeparator =
                "---------------------------------------------------------------------------------------------------------------";

        String title = "|  Id  |                                            Question                                                  |";

        StringBuilder sb = new StringBuilder(lineSeparator);
        sb.append(System.lineSeparator());
        sb.append(title)
                .append(System.lineSeparator())
                .append(lineSeparator);
        for (Map.Entry<Integer, Question> entry : questions.getRepository().entrySet()) {
            sb.append(System.lineSeparator())
                    .append(String.format("| %3s  | %-100s |", entry.getKey(), entry.getValue().getQuestion()));
        }
        sb.append(System.lineSeparator())
                .append(lineSeparator);
        System.out.println(sb);
    }
}
