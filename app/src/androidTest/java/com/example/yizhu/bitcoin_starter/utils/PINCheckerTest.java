package com.example.yizhu.bitcoin_starter.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static org.junit.Assert.*;

public class PINCheckerTest {

    @Test
    public void isValidPIN() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        String testPin = "123456";
        boolean result = PINChecker.isValidPIN(appContext,testPin);
        assertEquals(result, true);

        testPin = "12345";
        result = PINChecker.isValidPIN(appContext,testPin);
        assertEquals(result, false);
    }

    @Test
    public void isPinSameWithCurrent(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        AppStore.savePIN(appContext,"123456");
        boolean result = PINChecker.isPinSameWithCurrent(appContext,"654321");
        assertEquals(result, false);
        result = PINChecker.isPinSameWithCurrent(appContext,"123456");
        assertEquals(result, true);
    }

}