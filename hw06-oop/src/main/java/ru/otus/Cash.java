package ru.otus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Cash {
    private final Map<Denomination, Integer> denominationsMap;

    public Cash() {
        this.denominationsMap = new HashMap<>();
    }

    public void apply(List<Denomination> denominations) {
        denominations.forEach(denomination -> denominationsMap.put(denomination, denominationsMap.get(denomination) + 1));
    }

    public Map<Denomination, Integer> getDenominationsMap() {
        return denominationsMap;
    }

    public int mergeCashes(Cash anotherCash) {
        AtomicInteger cashAmount = new AtomicInteger();
        anotherCash.getDenominationsMap()
                .forEach(
                        (denomination, amount) ->  {
                            getDenominationsMap().put(denomination,
                                            getDenominationsMap().get(denomination) + amount);
                            cashAmount.addAndGet(amount);
                        }
                );
        return cashAmount.get();
    }
}
