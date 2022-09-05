package com.Tropic.AllCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PercentageCalculator extends AppCompatActivity {
    EditText of,outof;
    Button per,btnres;
    TextView result6,w1;
    Spinner spinner;String select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage_calculator);
        of=findViewById(R.id.of);
        w1=findViewById(R.id.h1);
        outof=findViewById(R.id.outof);
        per=findViewById(R.id.btn);
        btnres=findViewById(R.id.btnres);
        spinner=findViewById(R.id.spinner6);
        result6=findViewById(R.id.result6);
        of.addTextChangedListener(watcher);
        outof.addTextChangedListener(watcher);

        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                of.setText("");
                outof.setText("");
                result6.setText("");
            }
        });

        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weg= outof.getText().toString();
                String hei= of.getText().toString();
                float val= Float.parseFloat(weg);
                float Val= Float.parseFloat(hei);
                if (select.equals("Calculate Percentage")){
                    float perValue= PERCalculate(Val,val);
                    result6.setText("Percentage = " + perValue+ "%");
                }else if (select.equals("Calculate Value")){
                    float periValue= PERCalculate(Val,val);
                    result6.setText("Value = " + periValue);
                }
            }
        });

        List<String> shapes=new ArrayList<String>();
        shapes.add("Select!");
        shapes.add("Calculate Percentage");
        shapes.add("Calculate Value");


        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,shapes);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                select = adapterView.getItemAtPosition(position).toString();



                if (select.equals("Calculate Percentage")) {
                    w1.setText("Value");
                } else if (select.equals("Calculate Value")) {
                    w1.setText("Percentage");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }public float PERCalculate(float Val,float Tval){
        if (select.equals("Calculate Percentage")){
            return (Val * 100) / Tval;

        }else if (select.equals("Calculate Value")){
            return (Val * Tval) / 100;

        } return 0;
    }
    private TextWatcher watcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String h= of.getText().toString().trim();
            String w= outof.getText().toString().trim();
            per.setEnabled(!h.isEmpty() && !w.isEmpty());
            btnres.setEnabled(!h.isEmpty() && !w.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
