package quiz.core;

import quiz.io.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineImpl implements Engine {

    private final BufferedReader reader;
    private final Controller controller;

    public EngineImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.controller = new ControllerImpl();
    }

    @Override
    public void run() {

        while (true) {
            String result;
            try {
                result = processInput();
                if (result.equals("exit")) {
                    break;
                }
            } catch (IOException e) {
                result = e.getMessage();
            }
            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        Printer.printMenu();
        String input = reader.readLine();
        String result = null;

        switch (input) {
            case "1":
                result = controller.startTest();
                break;
            case "2":
                result = controller.addNewQuestion();
                break;
            case "3":
                result = controller.removeQuestion();
                break;
            case "4":
                controller.exit();
                result = "exit";
        }
        return result;
    }
}
