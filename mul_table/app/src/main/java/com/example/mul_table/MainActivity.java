package com.example.mul_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num,range,fact;
    Button multiple,factorial;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (EditText) findViewById(R.id.num);
        range = (EditText) findViewById(R.id.range);
        fact = (EditText) findViewById(R.id.fact);
        result =(TextView) findViewById(R.id.res);
        multiple = (Button) findViewById(R.id.multiplebutton);
        factorial = (Button) findViewById(R.id.factbutton);
        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("num",num.getText().toString());
                i.putExtra("range",range.getText().toString());
                startActivity(i);
            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = fact.getText().toString();
                int n = Integer.parseInt(f);
                int fact1 = 1;
                for(int i=1;i<=n;i++){
                    fact1=fact1*i;
                }
                String fact2 = String.valueOf(fact1);
                result.setText(fact2);
            }
        });
    }
}