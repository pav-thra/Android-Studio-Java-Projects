package com.example.radiogroupcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout ly;
    RadioGroup rp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ly=findViewById(R.id.con);
        rp=findViewById(R.id.rg);
        rp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.red:
                        ly.setBackgroundColor(Color.RED);
                        Toast.makeText(MainActivity.this, "Red Color", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.blue:
                        ly.setBackgroundColor(Color.BLUE);
                        Toast.makeText(MainActivity.this, "Blue Color", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.green:
                        ly.setBackgroundColor(Color.GREEN);
                        Toast.makeText(MainActivity.this, "Green Color", Toast.LENGTH_SHORT).show();
                        break;


                }
            }
        });

    }
}