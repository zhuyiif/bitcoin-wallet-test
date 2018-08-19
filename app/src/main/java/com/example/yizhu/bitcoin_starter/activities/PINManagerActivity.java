package com.example.yizhu.bitcoin_starter.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yizhu.bitcoin_starter.R;
import com.example.yizhu.bitcoin_starter.utils.AppStore;
import com.example.yizhu.bitcoin_starter.utils.PINChecker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class PINManagerActivity extends AppCompatActivity {

    @BindView(R.id.pinFirst) EditText firstEditText;
    @BindView(R.id.pinSecond) EditText secondEditText;
    @BindView(R.id.btnSubmit) Button submitButton;

    private static final String TAG = PINManagerActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin_manager);
        ButterKnife.bind(this);

        if(!AppStore.isFirstRun(getApplicationContext())) {
            finish();
            Intent intent = new Intent(this, PINVerifyActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppStore.saveLoginWhenFirst(getApplicationContext());
    }

    @OnClick(R.id.btnSubmit)
    public void submit() {

        String firstPin = firstEditText.getText().toString();
        String secondPin = secondEditText.getText().toString();
        if (!PINChecker.isValidPIN(this,firstPin) || !PINChecker.isValidPIN(this,secondPin)) {
            Toast.makeText(this, "PIN is not valid, should length should be 6", Toast.LENGTH_SHORT).show();
            return;
        }

        if (firstPin.equals(secondPin)) {
            //save password
            AppStore.savePIN(getApplicationContext(),firstEditText.getText().toString());
            Toast.makeText(this, "PIN is saved", Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(this, BitCoinWalletActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "PIN not match", Toast.LENGTH_SHORT).show();
        }
    }
}
