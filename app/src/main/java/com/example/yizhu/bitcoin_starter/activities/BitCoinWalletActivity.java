package com.example.yizhu.bitcoin_starter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yizhu.bitcoin_starter.R;
import com.example.yizhu.bitcoin_starter.utils.BitCoinJWallet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BitCoinWalletActivity extends AppCompatActivity {

    private BitCoinJWallet wallet;
    @BindView(R.id.myAddress)
    TextView myAddress;

    @BindView(R.id.myPrivateKey)
    TextView myPrivateKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitcoin_wallet);
        ButterKnife.bind(this);
        wallet = new BitCoinJWallet();
    }

    @OnClick(R.id.btnChangePIN)
    public void submit() {
        Intent intent = new Intent(this, PINUpdateActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.createAddress)
    public void createAddress() {
        wallet.CreateMyAddress();
        myAddress.setText(wallet.getMyAddress());
    }

    @OnClick(R.id.showPrivateKey)
    public void showPrivateKey() {
        myPrivateKey.setText(wallet.getMyPrivateKey());
    }
}
