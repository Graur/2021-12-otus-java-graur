package ru.otus;

public class Main {
    public static void main(String[] args) {
        TestLogging testLogging = ProxyBuilder.createMyClass();
        testLogging.calculation(6);
    }
}
