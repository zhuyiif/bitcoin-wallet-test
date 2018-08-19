package com.example.yizhu.bitcoin_starter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static com.example.yizhu.bitcoin_starter.utils.AppStore.SHARED_PREFERENCES_KEY;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AppStoreTest {

    @Test
    public void isFirstRun() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        AppStore.saveLoginWhenFirst(appContext);
        boolean isFirst = AppStore.isFirstRun(appContext);
        assertEquals(isFirst,false);

        // remove the first run token ,and check if it's first
        SharedPreferences.Editor editor = appContext.getSharedPreferences(SHARED_PREFERENCES_KEY, appContext.MODE_PRIVATE).edit();
        editor.remove(AppStore.IS_FIRST_TOKEN);
        editor.commit();
        isFirst = AppStore.isFirstRun(appContext);
        assertEquals(isFirst,true);

    }

    @Test
    public void saveLoginWhenFirst() {
    }

    @Test
    public void savePIN() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        String pin = "123456";
        AppStore.savePIN(appContext,pin);
        String getPin = AppStore.getPIN(appContext);
        assertEquals(pin, getPin);
    }

}