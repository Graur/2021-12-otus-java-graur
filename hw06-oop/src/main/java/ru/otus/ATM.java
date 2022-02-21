package ru.otus;

public class ATM {
    private int balance;
    private Cash cash;

    public void deposit(Cash cash) {
        balance += cash.mergeCashes(cash);
    }

    public Cash withdraw(int cash) {
        return null;
    }

    public int checkBalance() {
        return balance;
    }
}
