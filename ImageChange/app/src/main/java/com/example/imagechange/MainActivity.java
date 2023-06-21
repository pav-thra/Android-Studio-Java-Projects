package com.example.imagechange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button b;
ImageView i;
int k=0;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.btn);
        i=findViewById(R.id.imgv);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k+=1;
                if(k%2==0)
                {
                    i.setImageResource(R.drawable.img1);
                }
                else {
                    i.setImageResource(R.drawable.img2);
                }
            }
        });
    }
}