package quiz.core;

import quiz.entity.Question;
import quiz.io.JsonFileReader;
import quiz.io.JsonFileWriter;
import quiz.io.Printer;
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
    public String startTest() throws IOException {

        repository = jsonFileReader.readData();

        if (repository.getRepository().isEmpty()) {
            return "Question database is empty. Add new questions." + System.lineSeparator();
        }

        int correctAnswers = 0;
        for (Question question : repository.getRepository().values()) {
            System.out.println((question));

            String answer = reader.readLine();
            if (answer.equals(question.getCorrect())) {
                correctAnswers++;
            }
        }
        return Printer.printResult(correctAnswers, repository.getSize());
    }

    @Override
    public String addNewQuestion() throws IOException {

        repository = jsonFileReader.readData();

        Question question = populateQuestionTemplate();

        boolean freeSlot = false;
        int slot = 0;
        for (int i = 1; i <= repository.getSize(); i++) {
            if (!repository.getRepository().containsKey(i)) {
                freeSlot = true;
                slot = i;
                break;
            }
        }
        if (freeSlot) {
            repository.addQuestion(slot, question);
        } else {
            repository.addQuestion(repository.getSize() + 1, question);
        }

        return "Question successfully added to repository.";
    }

    @Override
    public String removeQuestion() throws IOException {

        repository = jsonFileReader.readData();

        Printer.printAll(repository);
        System.out.println("Enter the Id number of the question you want to delete: ");
        String input = reader.readLine();
        boolean isDigit = Character.isDigit(input.charAt(0));

        while (input.isBlank() || !isDigit) {
            System.out.println("Invalid input!");
            input = reader.readLine();
            isDigit = Character.isDigit(input.charAt(0));
        }
        boolean isExist = repository.getRepository().containsKey(Integer.parseInt(input));
        if (!isExist) {
            throw new NullPointerException("No element with such Id. Operation canceled!");
        }
        repository.removeQuestion(Integer.parseInt(input));
        return String.format("Question number: %s - successfully deleted", input);
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
