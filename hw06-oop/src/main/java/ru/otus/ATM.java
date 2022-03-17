package ru.otus;

import ru.otus.data.Denomination;
import ru.otus.exception.NotEnoughMoneyException;

import java.util.*;

public class ATM {
    private final Map<Denomination, Integer> atmDenominations;

    public ATM() {
        this.atmDenominations = new LinkedHashMap<>();
        this.atmDenominations.put(Denomination.FIVE_THOUSAND, 0);
        this.atmDenominations.put(Denomination.THOUSAND, 0);
        this.atmDenominations.put(Denomination.FIVE_HUNDRED, 0);
        this.atmDenominations.put(Denomination.HUNDRED, 0);
        this.atmDenominations.put(Denomination.TEN, 0);
    }

    public void deposit(List<Denomination> denominations) {
        denominations.forEach(denomination -> {
            int count = atmDenominations.get(denomination);
            atmDenominations.put(denomination, count + 1);
        });
    }

    public List<Denomination> withdraw(int cash) {
        if (cash > checkBalance()) {
            throw new NotEnoughMoneyException("There is not enough money for this operation");
        }
        List<Denomination> withdrawCash = new ArrayList<>();
        for (Denomination denomination : atmDenominations.keySet())  {
            while(cash >= denomination.getAmount()) {
                cash -= denomination.getAmount();
                withdrawCash.add(denomination);
            }
        }
        return withdrawCash;
    }

    public int checkBalance() {
        int balance = 0;
        for (Denomination denomination : atmDenominations.keySet()) {
            balance += denomination.getAmount() * atmDenominations.get(denomination);
        }
        return balance;
    }
}
