package core;

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
            Printer.printMenu();
            String input;

            try {
                input = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (input) {
                case "1":
                    try {
                        controller.startTest();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "2":
                    try {
                        controller.addNewQuestion();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    try {
                        controller.exit();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return;
            }
        }
    }

}
