package ru.otus.service;

import ru.otus.data.Balance;
import ru.otus.data.Denomination;
import ru.otus.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WithdrawService {

    private final List<Denomination> denominations;

    public WithdrawService() {
        this.denominations = Arrays.stream(Denomination.values()).sorted(Comparator.comparing(Denomination::getAmount).reversed()).toList();
    }

    public List<Denomination> withdraw(int cash, Balance balance) throws NotEnoughMoneyException {
        if (balance.getAmount() < cash) {
            throw new NotEnoughMoneyException("There is not enough money for this operation");
        }

        List<Denomination> withdrawCash = new ArrayList<>();
        denominations.forEach(denomination -> withdrawDenomination(balance, withdrawCash, denomination));
        return withdrawCash;
    }

    private void withdrawDenomination(Balance balance, List<Denomination> withdrawCash, Denomination denomination) {
        int denominationAmount = denomination.getAmount();
        while (balance.getAmount() >= denominationAmount) {
            balance.subtractBalance(denominationAmount);
            withdrawCash.add(denomination);
        }
    }
}
