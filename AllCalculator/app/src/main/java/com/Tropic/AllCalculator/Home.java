package com.Tropic.AllCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    Spinner spinner8, spinner7, spinner9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        spinner7 = findViewById(R.id.spinner7);
        spinner8 = findViewById(R.id.spinner8);
        spinner9 = findViewById(R.id.spinner9);

        List<String> shapes = new ArrayList<String>();
        shapes.add("Fitness");
        shapes.add("BMI Calculator");
        shapes.add("BMR Calculator");
        shapes.add("Calorie Calculator");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner1, shapes);

        dataAdapter.setDropDownViewResource(R.layout.spinner2);

        spinner7.setAdapter(dataAdapter);

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = adapterView.getItemAtPosition(position).toString();
                if (selected.equals("BMI Calculator")) {
                    Intent intent = new Intent(Home.this, BmiCalculator.class);
                    startActivity(intent);
                } else if (selected.equals("BMR Calculator")) {
                    Intent intent = new Intent(Home.this, BmrCalculator.class);
                    startActivity(intent);
                } else if (selected.equals("Calorie Calculator")) {
                    Intent intent = new Intent(Home.this, CalorieCalculator.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        List<String> shape = new ArrayList<String>();
        shape.add("Mathematics");
        shape.add("Standard Calculator");
        shape.add("Scientific Calculator");
        shape.add("Math Area Calculator");


        ArrayAdapter<String> dataAdapters = new ArrayAdapter<String>(this, R.layout.spinner1, shape);

        dataAdapters.setDropDownViewResource(R.layout.spinner2);

        spinner8.setAdapter(dataAdapters);

        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = adapterView.getItemAtPosition(position).toString();

                if (selected.equals("Standard Calculator")) {
                    Intent intent = new Intent(Home.this, simplecalculator.class);
                    startActivity(intent);
                } else if (selected.equals("Scientific Calculator")) {
                    Intent intent = new Intent(Home.this, Scientificcalculator.class);
                    startActivity(intent);
                } else if (selected.equals("Math Area Calculator")) {
                    Intent intent = new Intent(Home.this, mathareacalculator.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        List<String> shap = new ArrayList<String>();
        shap.add("Financial");
        shap.add("Percentage");
        shap.add("Profit & Loss");
        shap.add("Simple Interest");
        shap.add("Compound Interest");

        ArrayAdapter<String> dataAdapterss = new ArrayAdapter<String>(this, R.layout.spinner1, shap);
        dataAdapterss.setDropDownViewResource(R.layout.spinner2);

        spinner9.setAdapter(dataAdapterss);

        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = adapterView.getItemAtPosition(position).toString();

                if (selected.equals("Percentage")) {
                    Intent intent = new Intent(Home.this, PercentageCalculator.class);
                    startActivity(intent);
                } else if (selected.equals("Profit & Loss")) {
                    Intent intent = new Intent(Home.this, Profitandloss.class);
                    startActivity(intent);
                } else if (selected.equals("Simple Interest")) {
                    Intent intent = new Intent(Home.this, simpleinterest.class);
                    startActivity(intent);

                } else if (selected.equals("Compound Interest")) {
                    Intent intent = new Intent(Home.this, CompoundCalculator.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }


}
