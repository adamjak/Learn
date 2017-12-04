package net.adamjak.tomas.learn;

public class TestLearnException extends Exception {
    public TestLearnException() {
        super();
    }

    public TestLearnException(String message) {
        super(message);
    }

    public TestLearnException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestLearnException(Throwable cause) {
        super(cause);
    }
}
