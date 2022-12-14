package repository;

import entity.Question;

import java.util.Map;

public interface Repository {

    void addQuestion(int idNumber, Question question);

    Map<Integer, Question> getRepository();
    int getSize();
}
