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

public class mathareacalculator extends AppCompatActivity {
    EditText width,height,radius;
    TextView res,resu;
    Spinner spinner;
    Button reset;

    String select;
    double widthi=0.0;double heighti=0.0;double radiusi=0.0;
    Double result5=0.0;Double result0=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathareacalculator);
        height = findViewById(R.id.height);
        width = findViewById(R.id.width);
        radius = findViewById(R.id.radius);
        spinner = findViewById(R.id.spinner);
        res = findViewById(R.id.result);
        resu = findViewById(R.id.resu);
        reset = findViewById(R.id.btnrest);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                width.setText("");
                res.setText("");
                resu.setText("");
                radius.setText("");
            }
        });

        List<String> shapes = new ArrayList<String>();
        shapes.add("Select the Shape !");
        shapes.add("Circle");
        shapes.add("Square");
        shapes.add("Rectangle");
        shapes.add("Sphere");
        shapes.add("Cube");
        shapes.add("Triangle");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shapes);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select = parent.getItemAtPosition(position).toString();
                try {
                    widthi = Double.parseDouble(width.getText().toString());
                    heighti = Double.parseDouble(height.getText().toString());
                    radiusi = Double.parseDouble(radius.getText().toString());

                } catch (NumberFormatException e) {
                    System.out.println("Invalid Integer");
                }
                if (select.equals("Circle")) {
                    result5 = Math.PI * Math.pow(radiusi, 2);
                    result0 = 2 * Math.PI * radiusi;
                    res.setText("Area of circle= " + result5);
                    resu.setText("Perimeter of circle= " + result0);
                }
                else if (select.equals("Square")) {
                    result5 = Math.pow(widthi, 2);
                    result0 = 4 *widthi ;
                    res.setText("Area of square= " + result5);
                    resu.setText("Perimeter of square= " + result0);
                }
                else if (select.equals("Rectangle")) {
                    result5 = widthi* heighti;
                    result0 = 2 * ( + heighti);
                    res.setText("Area of rectangle= " + result5);
                    resu.setText("Perimeter of rectangle= " + result0);
                }
                else if (select.equals("Sphere")) {
                    result5 = 4 / 3 * Math.PI * Math.pow(radiusi, 3);
                    result0 = 4 * Math.PI * Math.pow(radiusi, 2);
                    res.setText("The Area sphere= " + result5);
                    resu.setText("Surface area of sphere= " + result0);
                }
                else if (select.equals("Cube")) {
                    result5 = Math.pow(widthi, 3);
                    result0 = 6 * Math.pow(widthi, 2);
                    res.setText("The Volume cube= " + result5);
                    resu.setText("Surface area of cube= " + result0);

                }
                else if (select.equals("Triangle")) {
                    result5 = (widthi * heighti) / 2;
                    res.setText("Area of triangle= " + result5);
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}