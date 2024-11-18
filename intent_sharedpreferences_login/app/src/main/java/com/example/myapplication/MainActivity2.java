package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v = (TextView) findViewById(R.id.user);
        SharedPreferences sp = getSharedPreferences("file",MODE_PRIVATE);
        String u = sp.getString("username","");
        v.setText("WELCOMES "+u);
    }
}