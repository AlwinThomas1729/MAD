package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.collections.UArraySortingKt;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.spinner);
        Button button = (Button) findViewById(R.id.button);

        // Fill the dropdown (spinner) with planets
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, planets);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String planet = spinner.getSelectedItem().toString();
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("selected",planet);
                startActivity(i);
                //Toast.makeText(MainActivity.this, "Planet: " + planet, Toast.LENGTH_SHORT).show();
            }
        });

        // Handle spinner selection
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String selectedPlanet = spinner.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), "Selected planet: " + selectedPlanet, Toast.LENGTH_SHORT).show();
//            }

//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
    }
}