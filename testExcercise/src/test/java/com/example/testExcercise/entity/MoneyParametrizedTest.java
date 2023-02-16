package com.example.testExcercise.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyParametrizedTest {


    private static final Object[] getMoney() {
        return new Object[] {
                new Object[] {10, "USD"},
                new Object[] {20, "EUR"}
        };
    }

//    private static final Object[] getMoney() {
//        return $ (
//                 $ (10, "USD"),
//                (20, "EUR");
//        );
//    }

    @ParameterizedTest
    @MethodSource(value = "getMoney")
    public void constructorShouldSetAmountAndCurrency (int amount, String currency) {
        Money money = new Money(amount,currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

}
