package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b;
    ConstraintLayout ly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.rc);
        ly=findViewById(R.id.l);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rn=new Random();
                int r=rn.nextInt(256);
                int g=rn.nextInt(256);
                int b=rn.nextInt(256);
                ly.setBackgroundColor(Color.rgb(r,g,b));
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
}