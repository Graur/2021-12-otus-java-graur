package ru.otus;

import ru.otus.data.Balance;
import ru.otus.data.Denomination;
import ru.otus.exception.NotEnoughMoneyException;
import ru.otus.service.DepositService;
import ru.otus.service.WithdrawService;

import java.util.List;

public class ATM {
    private final Balance balance;
    private final DepositService depositService;
    private final WithdrawService withdrawService;

    public ATM() {
        this.balance = new Balance();
        this.depositService = new DepositService();
        this.withdrawService = new WithdrawService();
    }

    public void deposit(List<Denomination> denominations) {
        balance.addBalance(depositService.apply(denominations));
    }

    public List<Denomination> withdraw(int cash) throws NotEnoughMoneyException {
        return withdrawService.withdraw(cash, balance);
    }

    public int checkBalance() {
        return balance.getAmount();
    }
}
