package com.sivov.test.core;

import java.io.IOException;

public interface Controller {
    void startTest() throws IOException;

    void addNewQuestion() throws IOException;

    void exit() throws IOException;
}
