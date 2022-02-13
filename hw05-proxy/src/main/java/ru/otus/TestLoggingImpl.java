package ru.otus;

public class TestLoggingImpl implements TestLogging {

    @Log
    public void calculation(int param) {
        System.out.println("invoke original method: " + this.getClass().getDeclaredMethods()[0]);
    };
}
