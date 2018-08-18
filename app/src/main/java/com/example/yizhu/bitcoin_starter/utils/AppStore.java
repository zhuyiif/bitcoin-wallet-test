package com.example.yizhu.bitcoin_starter.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppStore {


    public static final String SHARED_PREFERENCES_KEY ="BITCOIN_STARTER";

    public static final String IS_FIRST_TOKEN ="IS_LOGIN";

    public static final String PIN_TOKEN ="PIN";

    public static boolean isFirstRun(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES_KEY, context.MODE_PRIVATE);
        return  sp.getBoolean(IS_FIRST_TOKEN,true);
    }

    public static void saveLoginWhenFirst(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(SHARED_PREFERENCES_KEY, context.MODE_PRIVATE).edit();
        editor.putBoolean(IS_FIRST_TOKEN,false);
        editor.commit();
    }

    public static void savePIN(Context context, String pin) {
        SharedPreferences.Editor editor = context.getSharedPreferences(SHARED_PREFERENCES_KEY, context.MODE_PRIVATE).edit();
        editor.putString(PIN_TOKEN,pin);
        editor.commit();
    }

    public static String getPIN(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES_KEY, context.MODE_PRIVATE);
        return sp.getString(PIN_TOKEN,"");
    }




}
