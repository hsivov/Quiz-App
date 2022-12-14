package quiz;

import quiz.core.Engine;
import quiz.core.EngineImpl;

public class Main {

    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
