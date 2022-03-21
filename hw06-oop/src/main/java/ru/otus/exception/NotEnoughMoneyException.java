package ru.otus.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String explanation) {
        super(explanation);
    }
}
