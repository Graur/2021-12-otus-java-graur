package ru.otus.service;

import ru.otus.data.Denomination;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DepositService {

    public int apply(List<Denomination> denominations) {
        AtomicInteger cashAmount = new AtomicInteger();
        denominations.forEach(denomination -> cashAmount.addAndGet(Denomination.valueOf(denomination.name()).getAmount()));
        return cashAmount.get();
    }
}
