package com.example.testExcercise.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyIAETest {

    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";

    private static final Object[] getInvalidInput() {
        return new Integer[] [] {{-12387}, {-5}, {-1}};
    }

    @ParameterizedTest
    @MethodSource("getInvalidInput")
    public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
        assertThrows(IllegalArgumentException.class, () -> new Money(invalidAmount, VALID_CURRENCY));
    }

    public static final Object[] getInvalidCurrency() {
        return new String[][] {{null}, {""}};
    }

    @ParameterizedTest
    @MethodSource("getInvalidCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
        assertThrows(IllegalArgumentException.class, () -> new Money(VALID_AMOUNT, invalidCurrency));
    }

}
