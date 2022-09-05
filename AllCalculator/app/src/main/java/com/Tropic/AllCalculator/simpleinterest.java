package com.Tropic.AllCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class simpleinterest extends AppCompatActivity {
    EditText time,rate,prin; Button btncal,btnrest; TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleinterest);
        prin = findViewById(R.id.prin);
        rate = findViewById(R.id.rate);
        time = findViewById(R.id.time);
        btncal = findViewById(R.id.btncal);
        btnrest = findViewById(R.id.btnrest);
        result = findViewById(R.id.result);
        prin.addTextChangedListener(watcher);
        rate.addTextChangedListener(watcher);
        time.addTextChangedListener(watcher);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ra = rate.getText().toString();
                String pr = prin.getText().toString();
                String ti = time.getText().toString();

                float rate = Float.parseFloat(ra);
                float prin = Float.parseFloat(pr);
                float time = Float.parseFloat(ti) / 12;
                float siValue = SICalculate(prin, rate, time);
                result.setText("Simple interest = " + siValue);
            }

        });
        btnrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prin.setText("");
                rate.setText("");
                time.setText("");
                result.setText("");

            }
        });

    }
    public float SICalculate(float p, float r, float t) {
        return p*r*t/100;
    }

    private TextWatcher watcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String p= prin.getText().toString().trim();
            String r= rate.getText().toString().trim();
            String t= time.getText().toString().trim();
            btncal.setEnabled(!p.isEmpty() && !r.isEmpty() && !t.isEmpty());
            btnrest.setEnabled(!p.isEmpty() && !r.isEmpty() && !t.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}