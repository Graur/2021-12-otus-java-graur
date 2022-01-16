package ru.otus.homework;

import com.google.common.collect.ImmutableSet;

class HelloOtus {
    public static void main(String[] args) {
        ImmutableSet.of(1, 2, 3).forEach(System.out::println);
    }
}