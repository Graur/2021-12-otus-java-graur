package ru.otus;

public class Main {
    public static void main(String[] args) {
        TestLogging testLogging = ProxyBuilder.createMyClass();
        testLogging.calculation(6);
        testLogging.calculation(1, 3);
        testLogging.calculation(7,9,"One");
    }
}
