package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button b;
    String username = "ARUN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("arun@gmail.com") && password.getText().toString().equals("arun")){
                    SharedPreferences sp = getSharedPreferences("file",MODE_PRIVATE);
                    SharedPreferences.Editor e = sp.edit();
                    e.putString("username",username);
                    e.apply();
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}