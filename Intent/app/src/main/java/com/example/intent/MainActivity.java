package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (!user.equals("user") || !pass.equals("password")) {
                    Toast.makeText(MainActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    return;
                }
                // If the user is valid, navigate to the next activity
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("username", user);
                startActivity(intent);
            }
        });
    }
}