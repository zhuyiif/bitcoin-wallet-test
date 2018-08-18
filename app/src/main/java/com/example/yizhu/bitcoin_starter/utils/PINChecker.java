package com.example.yizhu.bitcoin_starter.utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.yizhu.bitcoin_starter.R;

public class PINChecker {

    // if user input 5 times wrong , exit app
    public static int MAX_INPUT_COUNT = 5;

    // check if it's valid PIN
    public static boolean isValidPIN(Context context,String pin) {
        boolean result = true;

        int pinLength = context.getResources().getInteger(R.integer.PIN_LEN);
        if (pin.length() != pinLength) {
            result = false;
        }
        //TODO may be need check if pin is number, for now the UI only allow user input number,
        return result;
    }
}
