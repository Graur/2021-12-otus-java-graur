package ru.otus.service;

import ru.otus.data.Denomination;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CashService {
    private final Map<Denomination, Integer> atmDenominations;

    public CashService() {
        this.atmDenominations = new LinkedHashMap<>();
        this.atmDenominations.put(Denomination.FIVE_THOUSAND, 0);
        this.atmDenominations.put(Denomination.THOUSAND, 0);
        this.atmDenominations.put(Denomination.FIVE_HUNDRED, 0);
        this.atmDenominations.put(Denomination.HUNDRED, 0);
        this.atmDenominations.put(Denomination.TEN, 0);
    }


    public void depositCash(Denomination denomination) {
        int count = atmDenominations.get(denomination);
        atmDenominations.put(denomination, count + 1);
    }

    public List<Denomination> withdrawCash(int cash, List<Denomination> withdrawCashList) {
        for (Denomination denomination : atmDenominations.keySet())  {
            while(cash >= denomination.getAmount()) {
                cash -= denomination.getAmount();
                withdrawCashList.add(denomination);
            }
        }
        return withdrawCashList;
    }

    public int getBalance() {
        int balance = 0;
        for (Denomination denomination : atmDenominations.keySet()) {
            balance += denomination.getAmount() * atmDenominations.get(denomination);
        }
        return balance;
    }
}
