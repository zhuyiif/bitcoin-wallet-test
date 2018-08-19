package com.example.yizhu.bitcoin_starter.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yizhu.bitcoin_starter.R;
import com.example.yizhu.bitcoin_starter.utils.AppStore;
import com.example.yizhu.bitcoin_starter.utils.PINChecker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PINUpdateActivity extends AppCompatActivity {

    @BindView(R.id.pinOld) EditText oldEditText;
    @BindView(R.id.pinFirst) EditText firstEditText;
    @BindView(R.id.pinSecond) EditText secondEditText;
    @BindView(R.id.btnSubmit) Button submitButton;

    private static final String TAG = PINUpdateActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin_modify);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSubmit)
    public void submit() {

        String oldPin = oldEditText.getText().toString();
        String firstPin = firstEditText.getText().toString();
        String secondPin = secondEditText.getText().toString();
        if (!PINChecker.isValidPIN(this,firstPin) || !PINChecker.isValidPIN(this,secondPin)) {
            Toast.makeText(this, "PIN is not valid, should length should be 6", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!firstPin.equals(secondPin)) {
            Toast.makeText(this, "PIN not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!PINChecker.isPinSameWithCurrent(this,oldPin)) {
            Toast.makeText(this, "old PIN not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if(oldPin.equals(firstPin)) {
            Toast.makeText(this, "new PIN is same with old", Toast.LENGTH_SHORT).show();
            return;
        }

        AppStore.savePIN(this, firstPin);
        Toast.makeText(this, "new PIN is saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
