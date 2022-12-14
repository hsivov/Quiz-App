package quiz.repository;

import quiz.entity.Question;

import java.util.LinkedHashMap;
import java.util.Map;

public class QuestionRepository implements Repository {

    private final Map<Integer, Question> questions;

    public QuestionRepository() {
        this.questions = new LinkedHashMap<>();
    }


    @Override
    public void addQuestion(int idNumber, Question question) {
        questions.put(idNumber, question);
    }

    @Override
    public Map<Integer, Question> getRepository() {
        return questions;
    }

    @Override
    public int getSize() {
        return questions.size();
    }
}
