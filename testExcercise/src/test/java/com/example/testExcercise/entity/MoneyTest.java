package com.example.testExcercise.entity;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");
        assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }
}