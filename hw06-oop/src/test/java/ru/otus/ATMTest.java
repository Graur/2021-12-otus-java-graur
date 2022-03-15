package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.data.Denomination;
import ru.otus.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @Test
    @DisplayName("Deposit 600 to ATM")
    void deposit() {
        //given
        List<Denomination> denominations = List.of(Denomination.HUNDRED, Denomination.FIVE_HUNDRED);
        //when
        atm.deposit(denominations);
        //then
        assertEquals(600, atm.checkBalance());
    }

    @Test
    @DisplayName("withdraw 500 from ATM")
    void withdraw() throws NotEnoughMoneyException {
        //given
        int cash = 500;
        List<Denomination> denominations = new ArrayList<>();
        denominations.add(Denomination.FIVE_HUNDRED);
        atm.deposit(denominations);
        //when
        List<Denomination> withdraw = atm.withdraw(cash);
        //then
        assertEquals(denominations, withdraw);
    }

    @Test
    @DisplayName("Check balance")
    void checkBalance() {
        //given
        List<Denomination> denominations = List.of(Denomination.HUNDRED, Denomination.FIVE_HUNDRED, Denomination.THOUSAND);
        //when
        atm.deposit(denominations);
        //then
        assertEquals(1600, atm.checkBalance());
    }

    @Test
    @DisplayName("NotEnoughMoneyException")
    void notEnoughMoney() {
        //given
        int cash = 1500;
        //when
        NotEnoughMoneyException thrown = assertThrows(
                NotEnoughMoneyException.class,
                () -> atm.withdraw(cash),
                "Expected  atm.withdraw() to throw, but it didn't"
        );
        //then
        assertTrue(thrown.getMessage().contains("There is not enough money for this operation"));
    }
}