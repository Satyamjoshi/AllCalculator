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

public class Profitandloss extends AppCompatActivity {
    EditText sp,cp;
    Button reset; TextView result;
    Spinner spinner;
    Double SP=0.0;
    Double CP=0.0;Double result1=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profitandloss);
        sp=findViewById(R.id.sp);
        cp=findViewById(R.id.cp);
        reset=findViewById(R.id.btnrese);
        result=findViewById(R.id.result);
        spinner=findViewById(R.id.spinner1);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setText("");
                cp.setText("");
                result.setText("");}
        });
        List<String> pl=new ArrayList<String>();
        pl.add("Select!");
        pl.add("Profit");
        pl.add("Loss");



        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,pl);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String select= adapterView.getItemAtPosition(position).toString();

                try {
                    SP = Double.parseDouble(sp.getText().toString());
                    CP = Double.parseDouble(cp.getText().toString());

                }catch (NumberFormatException e){
                    System.out.println("Invalid Integer");
                }


                if (select.equals("Profit")) {
                    result1 = SP-CP;
                    result.setText("Profit = " + result1);

                } else if (select.equals("Loss")) {
                    result1 = CP-SP;
                    result.setText("Loss = " + result1);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}