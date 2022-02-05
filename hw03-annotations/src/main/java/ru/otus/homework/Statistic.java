package ru.otus.homework;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Statistic {
    private Method before;
    private Method after;
    private List<Method> tests = new ArrayList<>();
    private int failedTestsCount;
    private int succeedTestsCount;

    public void increaseFailedTestsCount() {
        this.failedTestsCount++;
    }

    public void increaseSucceedTestsCount() {
        this.succeedTestsCount++;
    }
}
