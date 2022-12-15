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
        Printer.printResult(correctAnswers, repository.getRepository().size());
    }

    @Override
    public void addNewQuestion() throws IOException {
        System.out.println("Enter question:");
        String text = reader.readLine();
        System.out.println("Write answer A:");
        String a = reader.readLine();
        System.out.println("Write answer B:");
        String b = reader.readLine();
        System.out.println("Write answer C:");
        String c = reader.readLine();
        System.out.println("Write answer D:");
        String d = reader.readLine();
        System.out.println("Enter right answer:");
        String rightAnswer = reader.readLine();

        repository = jsonFileReader.readData();
        Question question = new Question(text, a, b, c, d, rightAnswer);
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
}
