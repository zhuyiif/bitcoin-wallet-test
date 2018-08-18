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
            Intent intent = new Intent(this, PINVerifyActivity.class);
            startActivity(intent);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
      //  AppStore.saveLoginWhenFirst(getApplicationContext());

    }

    @OnClick(R.id.btnSubmit)
    public void submit() {

        if (firstEditText.getText().toString().equals(secondEditText.getText().toString())) {
            //save password
            AppStore.savePIN(getApplicationContext(),firstEditText.getText().toString());

        }
        else {
            Toast.makeText(this, "passwords not match", Toast.LENGTH_SHORT).show();
        }
    }

}
