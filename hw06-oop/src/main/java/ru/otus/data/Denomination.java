package ru.otus.data;

public enum Denomination {
    TEN(10),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    FIVE_THOUSAND(5000);

    private final int amount;

    Denomination(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
