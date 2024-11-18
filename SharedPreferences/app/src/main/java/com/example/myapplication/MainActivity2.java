//package com.example.myapplication;
//
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity2 extends AppCompatActivity {
//
//    EditText username;
//    Button login;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main2);
//
//
//        username = findViewById(R.id.username);
//        login = findViewById(R.id.login);
//
//        // Handle login
//        login.setOnClickListener(e -> {
//            String user = username.getText().toString();
//            if (user.isEmpty()) {
//                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            // Save the username in SharedPreferences
//            SharedPreferences preferences = getSharedPreferences("credentials", MODE_PRIVATE);
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putString("username", user);
//            editor.apply();
//
//            // Redirect to main activity
//            finish();
//        });
//    }
//}



package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText username;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username = findViewById(R.id.username);
        login = findViewById(R.id.login);

        // Handle login button click
        login.setOnClickListener(v -> {
            String user = username.getText().toString().trim();
            if (user.isEmpty()) {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save the username in SharedPreferences
            SharedPreferences preferences = getSharedPreferences("credentials", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username", user);
            editor.apply();

            // Redirect to MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish(); // Prevent returning to this activity
        });
    }
}
