package com.sivov.test.core;

import com.sivov.test.entity.Question;
import com.sivov.test.io.FileReader;
import com.sivov.test.io.FileWriter;
import com.sivov.test.repository.Repository;
import com.sivov.test.repository.RepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerImpl implements Controller {

    Repository repository;
    BufferedReader reader;
    FileReader fileReader;
    FileWriter fileWriter;

    public ControllerImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.repository = new RepositoryImpl();
    }

    @Override
    public void startTest() throws IOException {
        fileReader = new FileReader("src/com/sivov/test/quizData.ser", repository);

        fileReader.readData();

        if (repository.getRepository().isEmpty()) {
            System.out.println(("Question database is empty. Add new questions.") + System.lineSeparator());
            return;
        }
        int correctAnswers = 0;
        for (Question question : repository.getRepository()) {
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
        String a = "a: " + reader.readLine();
        System.out.println("Write answer B:");
        String b = "b: " + reader.readLine();
        System.out.println("Write answer C:");
        String c = "c: " + reader.readLine();
        System.out.println("Write answer D:");
        String d = "d: " + reader.readLine();
        System.out.println("Enter right answer:");
        String rightAnswer = reader.readLine();

        Question question = new Question(text, a, b, c, d, rightAnswer);
        repository.addQuestion(question);
        System.out.println("Question successfully added to repository.");
    }

    @Override
    public void exit() throws IOException {
        this.fileWriter = new FileWriter("src/com/sivov/test/quizData.ser", repository);

        fileWriter.writeData();
    }
}
