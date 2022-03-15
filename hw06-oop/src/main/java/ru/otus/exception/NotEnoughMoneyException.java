package ru.otus.exception;

import javax.naming.OperationNotSupportedException;

public class NotEnoughMoneyException extends OperationNotSupportedException {
    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String explanation) {
        super(explanation);
    }
}
