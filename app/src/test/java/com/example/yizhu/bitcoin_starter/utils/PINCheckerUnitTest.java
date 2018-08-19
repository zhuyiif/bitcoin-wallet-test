package com.example.yizhu.bitcoin_starter.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class PINCheckerUnitTest {

    @Test
    public void isInputWrongTooMany() {

        int number = 1;
        boolean result = PINChecker.isInputWrongTooMany(number);
        assertEquals(result,false);

        number = 6;
        result = PINChecker.isInputWrongTooMany(number);
        assertEquals(result,true);
    }
}