package com.Tropic.AllCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CalorieCalculator extends AppCompatActivity {
    EditText height, weight, age;
    RadioButton male, female;
    TextView result;
    Button btnres;
    Spinner spinner;
    Double result5=0.0;Double h=0.0;Double w=0.0;Double a =0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        age = findViewById(R.id.eage);
        btnres = findViewById(R.id.btnres);
        spinner=findViewById(R.id.spinner3);
        result = findViewById(R.id.result);


        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                weight.setText("");
                result.setText("");
                age.setText("");
            }
        });


        List<String> pl=new ArrayList<String>();
        pl.add("Select!");
        pl.add("little or no exercise");
        pl.add("light exercise or sports 1-2 days/week");
        pl.add("moderate exercise or sports 2-3 days/week");
        pl.add("hard exercise or sports 4-5 days/week");
        pl.add("very hard exercise, physical job or sports 6-7 days/week");
        pl.add("Professional athlete");


        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,pl);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String select = adapterView.getItemAtPosition(position).toString();
                try {
                    h = Double.parseDouble(height.getText().toString());
                    w = Double.parseDouble(weight.getText().toString());
                    a = Double.parseDouble(age.getText().toString());


                } catch (NumberFormatException e) {
                    System.out.println("Invalid Integer");
                }

                if (male.isChecked()) {

                    if (select.equals("little or no exercise")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a + 5) * 1.2;
                        result.setText("Calorie = " + result5+" calorie/day");
                    } else if (select.equals("light exercise or sports 1-2 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a + 5) * 1.4;
                        result.setText("Calorie = " + result5+" calorie/day");

                    } else if (select.equals("moderate exercise or sports 2-3 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a + 5) * 1.6;
                        result.setText("Calorie = " + result5+" calorie/day");

                    } else if (select.equals("hard exercise or sports 4-5 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a + 5) * 1.75;
                        result.setText("Calorie = " + result5+" calorie/day");

                    } else if (select.equals("very hard exercise, physical job or sports 6-7 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a + 5) * 2.0;
                        result.setText("Calorie = " + result5+" calorie/day");
                    } else if (select.equals("Professional athlete")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a + 5) * 2.3;
                        result.setText("Calorie = " + result5+" calorie/day");
                    }} else if (female.isChecked()) {

                    if (select.equals("little or no exercise")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a - 161) * 1.2;
                        result.setText("Calorie = " + result5+" calorie/day");
                    } else if (select.equals("light exercise or sports 1-2 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a - 161) * 1.4;
                        result.setText("Calorie = " + result5+" calorie/day");

                    } else if (select.equals("moderate exercise or sports 2-3 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a - 161) * 1.6;
                        result.setText("Calorie = " + result5+" calorie/day");

                    } else if (select.equals("hard exercise or sports 4-5 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a - 161) * 1.75;
                        result.setText("Calorie = " + result5+" calorie/day");

                    } else if (select.equals("very hard exercise, physical job or sports 6-7 days/week")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a - 161) * 2.0;
                        result.setText("Calorie = " + result5+" calorie/day");
                    } else if (select.equals("Professional athlete")) {
                        result5 = (float) (10 * w + 6.25 * h - 5 * a - 161) * 2.3;
                        result.setText("Calorie = " + result5+" calorie/day");
                    }

                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    }
