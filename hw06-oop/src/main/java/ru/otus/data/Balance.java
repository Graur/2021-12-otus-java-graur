package ru.otus.data;

public class Balance {
    private int balance;

    public int getAmount() {
        return balance;
    }

    public void subtractBalance(int amount) {
        this.balance -= amount;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }
}
