package com.Tropic.AllCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiCalculator extends AppCompatActivity {
    EditText height, weight;
    TextView toast,resultt;String Calculation;
    Button btnres,btn;Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        toast=findViewById(R.id.toast);
        btn=findViewById(R.id.btn);
        btnres=findViewById(R.id.btnres);


        resultt=findViewById(R.id.result);
        height.addTextChangedListener(watcher);
        weight.addTextChangedListener(watcher);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weg= weight.getText().toString();
                String hei= height.getText().toString();
                float weight= Float.parseFloat(weg);
                float height= Float.parseFloat(hei)/100;
                float bmiValue= BMICalculate(weight,height);
                toast.setText(resultbmi(bmiValue));
                resultt.setText("BMI= " + bmiValue);
            }

        });  btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                weight.setText("");
                resultt.setText("");
                toast.setText("");
            }
        });

    }
    public float BMICalculate(float weight,float height) {
        return weight / (height * height);
    }
    public String resultbmi(float bmivalue) {
        if (bmivalue < 18) {
            return "Underweight";
        } else if (bmivalue > 18 && bmivalue < 25) {
            return "Normal" ;

        } else {
            return "Over Weight";
        }

    }
    private TextWatcher watcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String h= height.getText().toString().trim();
            String w= weight.getText().toString().trim();
            btn.setEnabled(!h.isEmpty() && !w.isEmpty());
            btnres.setEnabled(!h.isEmpty() && !w.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    }
