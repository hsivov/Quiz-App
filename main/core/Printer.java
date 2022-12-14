package com.sivov.test.core;

public class Printer {

    public static void printMenu() {
        System.out.println("Choose option:" +
                System.lineSeparator() + "1. Start Test" +
                System.lineSeparator() + "2. Add Question" +
                System.lineSeparator() + "3. Exit");
    }

    public static void printResult(int correctAnswers, int totalQuestions) {
        System.out.printf("You have answered correctly at %d of %d questions.%n", correctAnswers, totalQuestions);
    }
}
