package quiz.repository;

import quiz.entity.Question;

import java.util.Map;

public interface Repository {

    void addQuestion(int idNumber, Question question);

    void removeQuestion(int idNumber);

    Map<Integer, Question> getRepository();
    int getSize();
}
