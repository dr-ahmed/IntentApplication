package com.dev.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTxt;
    private Button goBackBtn;

    private static final String TAG = "SecondActivity";
    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        getDataFromMainActivity();
        setListeners();
    }

    private void initViews() {
        resultTxt = findViewById(R.id.result_txt);
        goBackBtn = findViewById(R.id.go_back_btn);
    }

    private void setListeners() {
        goBackBtn.setOnClickListener(this);
    }

    private void getDataFromMainActivity() {
        Intent intent = getIntent();
        String firstNumber = intent.getStringExtra("firstNumber"),
                secondNumber = intent.getStringExtra("secondNumber");
        sum = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        resultTxt.setText(firstNumber + "+" + secondNumber + "=" + sum);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.go_back_btn) {
            Log.e(TAG, "onClick called ");
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("sum", sum);
            startActivity(intent);
        }
    }
}
