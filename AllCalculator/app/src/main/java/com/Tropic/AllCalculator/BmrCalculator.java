package com.Tropic.AllCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class BmrCalculator extends AppCompatActivity {
    EditText height, weight, age;
    RadioButton male, female;
    TextView resultt;
    String Calculation;
    Button btnres, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_calculator);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        age = findViewById(R.id.eage);
        btn = findViewById(R.id.btn);
        btnres = findViewById(R.id.btnres);


        resultt = findViewById(R.id.result);
        height.addTextChangedListener(watcher);
        weight.addTextChangedListener(watcher);
        age.addTextChangedListener(watcher);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weg = weight.getText().toString();
                String hei = height.getText().toString();
                String ag = age.getText().toString();
                float weight = Float.parseFloat(weg);
                float height = Float.parseFloat(hei);
                float age = Float.parseFloat(ag);
                float bmrValue = BMRCalculate(weight, height, age);

                resultt.setText("BMR= " + bmrValue+" calorie/day");


            }
        });

        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                weight.setText("");
                resultt.setText("");
                age.setText("");


            }
        });
    }

    public float BMRCalculate(float weight, float height, float age) {

        if (male.isChecked()) {
            return (float) (10 * weight + 6.25 * height - 5 * age + 5);
        } else if (female.isChecked()) {
            return (float) (10 * weight + 6.25 * height - 5 * age - 161);
        }
        else {
            Toast.makeText(BmrCalculator.this, "Select gender", Toast.LENGTH_LONG).show();
        }
        return 0;
    }

    private TextWatcher watcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String h= height.getText().toString().trim();
            String w= weight.getText().toString().trim();
            String a= age.getText().toString().trim();

            btn.setEnabled(!h.isEmpty() && !w.isEmpty() && !a.isEmpty() );
            btnres.setEnabled(!h.isEmpty() && !w.isEmpty() && !a.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {
        }

    };


}
