package com.Tropic.AllCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CompoundCalculator extends AppCompatActivity {
    EditText p,r,t; Button reset;
    Spinner spinner;
    TextView result ,result4;
    Double P=0.0;
    Double ra=0.0;
    Double T=0.0;
    Double result2=0.0;    Double result3=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_calculator);
        p=findViewById(R.id.princ);
        r=findViewById(R.id.rat);
        t=findViewById(R.id.tim);
        reset=findViewById(R.id.btnreset);
        result=findViewById(R.id.result3);
        result4=findViewById(R.id.result4);
        spinner=findViewById(R.id.spinner2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setText("");
                r.setText("");
                t.setText("");
                result4.setText("");
                result.setText("");}
        });
        List<String> pl=new ArrayList<String>();
        pl.add("Select!");
        pl.add("Compounded Annually");
        pl.add("Compounded Half yearly");
        pl.add("Compounded Quarterly");
        pl.add("Compounded Monthly");

        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,pl);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String select = adapterView.getItemAtPosition(position).toString();
                try {
                    P = Double.parseDouble(p.getText().toString());
                    ra = Double.parseDouble(r.getText().toString());
                    T = Double.parseDouble(t.getText().toString())/12;

                }catch (NumberFormatException e){
                    System.out.println("Invalid Integer");
                }

                if (select.equals("Compounded Annually")) {
                    result2 =P*Math.pow(1+(ra/100),1*T);
                    result3=result2-P;
                    result4.setText("Amount ="+ result2);
                    result.setText("Compound Interest = "+result3);

                } else if (select.equals("Compounded Half yearly")) {
                    result2 = P*Math.pow(1+(ra/200),2*T);
                    result3=result2-P;
                    result4.setText("Amount = "+ result2);
                    result.setText("Compound Interest = "+ result3);

                }else if (select.equals("Compounded Quarterly")) {
                    result2 = P*Math.pow(1+(ra/400),4*T);
                    result3=result2-P;
                    result4.setText("Amount ="+ result2);
                    result.setText("Compound Interest = "+result3);

                }else if (select.equals("Compounded Monthly")) {
                    result2 = P*Math.pow(1+(ra/1200),12*T);
                    result3=result2-P;
                    result4.setText("Amount ="+ result2);
                    result.setText("Compound Interest = "+result3);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    }
