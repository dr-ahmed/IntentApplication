package com.dev.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstNumberEdt, secondNumberEdt;
    private Button calculateBtn;
    private TextView sumTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListeners();

        if (getIntent().hasExtra("sum")) {
            sumTxt.setText("Somme=" + getIntent().getIntExtra("sum", -1));
        }
    }

    private void initViews() {
        firstNumberEdt = findViewById(R.id.first_number_edt);
        secondNumberEdt = findViewById(R.id.second_number_edt);
        calculateBtn = findViewById(R.id.calculate_btn);
        sumTxt = findViewById(R.id.sum_txt);
    }

    private void setListeners() {
        calculateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.calculate_btn) {
            Intent intent = new Intent(getBaseContext(), SecondActivity.class);
            intent.putExtra("firstNumber", firstNumberEdt.getText().toString());
            intent.putExtra("secondNumber", secondNumberEdt.getText().toString());
            startActivity(intent);
        }
    }
}
