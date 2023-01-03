package quiz.repository;

import quiz.entity.Question;

import java.util.Map;
import java.util.TreeMap;

public class QuestionRepository implements Repository {

    private final Map<Integer, Question> questions;

    public QuestionRepository() {
        this.questions = new TreeMap<>();
    }


    @Override
    public void addQuestion(int idNumber, Question question) {
        questions.put(idNumber, question);
    }

    @Override
    public void removeQuestion(int idNumber) {
        questions.remove(idNumber);
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
