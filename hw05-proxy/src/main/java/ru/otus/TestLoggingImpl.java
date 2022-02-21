package ru.otus;

public class TestLoggingImpl implements TestLogging {

    @Log
    public void calculation(int param) {
        System.out.printf("executed original method: calculation(%s)%n", param);
    }

    @Log
    @Override
    public void calculation(int param1, int param2) {
        System.out.printf("executed original method: calculation(%s, %s)%n", param1, param2);
    }

    @Log
    @Override
    public void calculation(int param1, int param2, String param3) {
        System.out.printf("executed original method: calculation(%s, %s, %s)%n", param1, param2, param3);
    }
}
