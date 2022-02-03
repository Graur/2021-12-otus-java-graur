package ru.otus.homework;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class AnnotationTest {

    @Before
    public void setUp() {
        System.out.println("Before all tests");
    }

    @After
    public void tearDown() {
        System.out.println("After all tests");
    }

    @Test
    public void test1() {
        System.out.println("Test1");
    }

    @Test
    public void test2() {
        System.out.println("Test2");
    }

    @Test
    public void test3() {
        System.out.println("Test3");
    }

    @Test
    public void test4() {
        System.out.println("Test4");
    }

    @Test
    public void test5() {
        System.out.println("Test5 with exception");
        throw new IllegalArgumentException();
    }
}
