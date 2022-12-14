package entity;

public class Question {

    private final String question;
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String correct;

    public Question(String question, String a, String b, String c, String d, String correct) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getCorrect() {
        return correct;
    }

    @Override
    public String toString() {

        return System.lineSeparator() + getQuestion() +
                System.lineSeparator() +
                System.lineSeparator() +
                "a: " + getA() + System.lineSeparator() +
                "b: " + getB() + System.lineSeparator() +
                "c: " + getC() + System.lineSeparator() +
                "d: " + getD() + System.lineSeparator() +
                System.lineSeparator() +
                "Enter your answer: ";
    }
}
