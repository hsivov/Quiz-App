package com.sivov.test;

import com.sivov.test.core.Engine;
import com.sivov.test.core.EngineImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
