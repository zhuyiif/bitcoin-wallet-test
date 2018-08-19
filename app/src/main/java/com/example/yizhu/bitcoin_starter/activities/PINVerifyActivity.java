package com.example.yizhu.bitcoin_starter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yizhu.bitcoin_starter.R;
import com.example.yizhu.bitcoin_starter.utils.AppStore;
import com.example.yizhu.bitcoin_starter.utils.PINChecker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PINVerifyActivity extends AppCompatActivity {

    @BindView(R.id.pin) EditText pinText;
    private int inputWrongTimes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin_verify);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSubmit)
    public void submit() {
        if (PINChecker.isPinSameWithCurrent(this,pinText.getText().toString())) {
            Toast.makeText(this, "PIN is OK", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, BitCoinWalletActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            intent.putExtra("result", true);
            setResult(RESULT_OK, intent);
            startActivity(intent);
            finish();
        }
        else {
            inputWrongTimes++;
            if (PINChecker.isInputWrongTooMany(inputWrongTimes)) {
                Toast.makeText(this, "Too many PIN attempts. Please try again later", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                Toast.makeText(this, "PIN not match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
