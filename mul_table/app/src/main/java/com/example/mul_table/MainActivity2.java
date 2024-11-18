package com.example.mul_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=(TextView) findViewById(R.id.textView);
        String n=getIntent().getStringExtra("num");
        String r=getIntent().getStringExtra("range");
        int num=Integer.parseInt(n);
        int range=Integer.parseInt(r);
        StringBuilder res=new StringBuilder();
        for(int i=1;i<=range;i++)
        {
           res.append(i).append("*").append(num).append("=").append(i*num).append("\n");
        }
        t.setText(res);
    }
}