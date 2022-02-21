package ru.otus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deposit() {
        //given
        Cash cash = new Cash();
        List<Denomination> denominations = List.of(Denomination.HUNDRED, Denomination.FIVE_HUNDRED);
        //when
        cash.apply(denominations);
        atm.deposit(cash);
        //then
        assertEquals(600, atm.checkBalance());
    }

    @Test
    void withdraw() {
    }

    @Test
    void checkBalance() {
    }
}