package quiz.core;

import quiz.entity.Question;
import quiz.io.JsonFileReader;
import quiz.io.JsonFileWriter;
import quiz.repository.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerImpl implements Controller {

    Repository repository;
    BufferedReader reader;
    JsonFileReader jsonFileReader;

    public ControllerImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.jsonFileReader = new JsonFileReader();
    }

    @Override
    public void startTest() throws IOException {

        repository = jsonFileReader.readData();

        if (repository.getRepository().isEmpty()) {
            System.out.println(("Question database is empty. Add new questions.") + System.lineSeparator());
            return;
        }

        int correctAnswers = 0;
        for (Question question : repository.getRepository().values()) {
            System.out.println((question));

            String answer = reader.readLine();
            if (answer.equals(question.getCorrect())) {
                correctAnswers++;
            }
        }
        Printer.printResult(correctAnswers, repository.getSize());
    }

    @Override
    public void addNewQuestion() throws IOException {

        repository = jsonFileReader.readData();

        Question question = populateQuestionTemplate();

        repository.addQuestion(repository.getSize() + 1, question);
        System.out.println("Question successfully added to repository.");
    }

    @Override
    public void exit() throws IOException {
        JsonFileWriter jsonFileWriter = new JsonFileWriter(repository);

        if (repository != null) {
            jsonFileWriter.writeData();
        }
    }

    private Question populateQuestionTemplate() throws IOException {
        String text = "";
        while (text.isBlank()) {
            System.out.println("Enter question:");
            text = reader.readLine();
            if (text.isBlank()) {
                System.out.println("Field cannot be blank!");
            }
        }
        String a = "";
        while (a.isBlank()) {
            System.out.println("Write answer A:");
            a = reader.readLine();
            if (a.isBlank()) {
                System.out.println("Field cannot be blank!");
            }
        }
        String b = "";
        while (b.isBlank()) {
            System.out.println("Write answer B:");
            b = reader.readLine();
            if (b.isBlank()) {
                System.out.println("Field cannot be blank!");
            }
        }
        String c = "";
        while (c.isBlank()) {
            System.out.println("Write answer C:");
            c = reader.readLine();
            if (c.isBlank()) {
                System.out.println("Field cannot be blank!");
            }
        }
        String d = "";
        while (d.isBlank()) {
            System.out.println("Write answer D:");
            d = reader.readLine();
            if (d.isBlank()) {
                System.out.println("Field cannot be blank!");
            }
        }
        String rightAnswer = "";
        while (rightAnswer.isBlank()) {
            System.out.println("Enter right answer:");
            rightAnswer = reader.readLine();
            if (rightAnswer.isBlank()) {
                System.out.println("Field cannot be blank!");
            }
        }

        return new Question(text, a, b, c, d, rightAnswer);
    }
}
