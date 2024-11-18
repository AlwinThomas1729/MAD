package com.example.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button web, dial, mail, text;
    EditText textInput, urlInput, phoneInput, email, subject, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        web = findViewById(R.id.web);
        dial = findViewById(R.id.dial);
        mail = findViewById(R.id.mail);
        text = findViewById(R.id.text);

        textInput = findViewById(R.id.textInput);
        urlInput = findViewById(R.id.urlInput);
        phoneInput = findViewById(R.id.phoneInput);
        email = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        content = findViewById(R.id.content);

        // Open any website in a browser
        web.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(urlInput.getText().toString())
            );
            startActivity(intent);
        });

        // Dial a phone number
        dial.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + phoneInput.getText())
            );
            startActivity(intent);
        });

        // Send an email
        mail.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:" + email.getText())
            );
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, content.getText().toString());
            startActivity(intent);
        });

        // Share a text with other apps
        text.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, textInput.getText());
            // Let the user choose what app to share with
            startActivity(Intent.createChooser(intent, "Share with"));
        });
    }
}