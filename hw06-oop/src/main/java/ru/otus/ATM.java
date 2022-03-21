package ru.otus;

import ru.otus.data.Denomination;

import java.util.*;

public interface ATM {

    void deposit(List<Denomination> denominations);

    List<Denomination> withdraw(int cash);

    int checkBalance();
}
