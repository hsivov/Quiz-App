package quiz.core;

import java.io.IOException;

public interface Controller {
    String startTest() throws IOException;

    String addNewQuestion() throws IOException;

    String removeQuestion() throws IOException;

    void exit() throws IOException;
}
