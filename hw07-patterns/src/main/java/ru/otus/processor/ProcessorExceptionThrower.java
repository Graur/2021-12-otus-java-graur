package ru.otus.processor;

import ru.otus.model.Message;
import ru.otus.processor.homework.EvenSecondsException;

import java.time.LocalDateTime;

public class ProcessorExceptionThrower implements Processor {
    private final LocalDateTime time;

    public ProcessorExceptionThrower(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public Message process(Message message) {
        if (time.getSecond() % 2 == 0) {
            throw new EvenSecondsException("throw exception on every even second in ProcessorExceptionThrower");
        }
        return message;
    }
}
