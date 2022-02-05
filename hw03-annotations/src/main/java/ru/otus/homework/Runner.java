package ru.otus.homework;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;
import ru.otus.reflection.ReflectionHelper;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Runner {
    public void run(Class<?> clazz) {
        Statistic statistic = new Statistic();
        getAnnotatedMethods(clazz.getMethods(), statistic);
        statistic.getTests().forEach(method -> invokeAndCallTest(clazz, method, statistic));
        printStatistic(statistic);
    }

    private void getAnnotatedMethods(Method[] methods, Statistic statistic) {
        Arrays.stream(methods)
                .forEach(method -> {
                    if (method.isAnnotationPresent(Test.class)) {
                        statistic.getTests().add(method);
                    } else if (method.isAnnotationPresent(Before.class)) {
                        statistic.setBefore(method);
                    } else if (method.isAnnotationPresent(After.class)) {
                        statistic.setAfter(method);
                    }
                });
    }

    private void printStatistic(Statistic statistic) {
        System.out.println("Statistic: total tests: " + statistic.getTests().size()
                + ", test passed: " + statistic.getSucceedTestsCount()
                + ", test failed: " + statistic.getFailedTestsCount());
    }

    private void invokeAndCallTest(Class<?> clazz, Method method, Statistic statistic) {
        Object instant = null;
        boolean isFailed = false;
        try {
            instant = ReflectionHelper.instantiate(clazz);
            ReflectionHelper.callMethod(instant, statistic.getBefore().getName());
            ReflectionHelper.callMethod(instant, method.getName());
        } catch (Exception | Error e) {
            statistic.increaseFailedTestsCount();
            isFailed = true;
        } finally {
            try {
                ReflectionHelper.callMethod(instant, statistic.getAfter().getName());
                statistic.increaseSucceedTestsCount();
            } catch (RuntimeException e) {
                if (!isFailed) {
                    statistic.increaseFailedTestsCount();
                }
            }
        }
    }

}
