package ru.otus.service;

import ru.otus.ATM;
import ru.otus.data.Denomination;
import ru.otus.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

public class AtmService implements ATM {
    private final CashService cashService;

    public AtmService() {
        this.cashService = new CashService();
    }

    @Override
    public void deposit(List<Denomination> denominations) {
        denominations.forEach(cashService::depositCash);
    }

    @Override
    public List<Denomination> withdraw(int cash) {
        if (cash > checkBalance()) {
            throw new NotEnoughMoneyException("There is not enough money for this operation");
        }
        List<Denomination> withdrawCashList = new ArrayList<>();
        return cashService.withdrawCash(cash, withdrawCashList);
    }

    @Override
    public int checkBalance() {
        return cashService.getBalance();
    }
}
