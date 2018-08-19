package com.example.yizhu.bitcoin_starter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yizhu.bitcoin_starter.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BitCoinWalletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitcoin_wallet);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnChangePIN)
    public void submit() {
        Intent intent = new Intent(this, PINUpdateActivity.class);
        startActivity(intent);
    }
}
