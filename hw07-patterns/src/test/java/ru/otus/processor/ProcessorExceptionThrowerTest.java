package ru.otus.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.model.Message;
import ru.otus.processor.homework.EvenSecondsException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorExceptionThrowerTest {

    @Test
    @DisplayName("выбрасывать исключение в четную секунду")
    void throwErrorAtEvenSeconds() {
        //given
        var message = new Message.Builder(45L).build();
        Processor processor = new ProcessorExceptionThrower(LocalDateTime.of(2022, 1, 2, 3, 4, 6));

        //when
        EvenSecondsException thrown = assertThrows(
                EvenSecondsException.class,
                () -> processor.process(message),
                "Expected processor.process(message) to throw, but it didn't"
        );
        //then
        assertTrue(thrown.getMessage().contains("throw exception on every even second in ProcessorExceptionThrower"));
    }

    @Test
    @DisplayName("не выбрасывать исключение в нечетную секунду")
    void doNotThrowAnErrorAtOddSeconds() {
        //given
        var message = new Message.Builder(45L).build();
        Processor processor = new ProcessorExceptionThrower(LocalDateTime.of(2022, 1, 2, 3, 4, 5));
        //when
        processor.process(message);
    }
}