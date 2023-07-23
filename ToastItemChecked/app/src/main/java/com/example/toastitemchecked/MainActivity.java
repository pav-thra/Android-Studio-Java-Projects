package com.example.toastitemchecked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox p,pp,mp;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=findViewById(R.id.c1);
        pp=findViewById(R.id.c2);
        mp=findViewById(R.id.c3);
        b=findViewById(R.id.order);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="";
                if(p.isChecked())
                    s=s+p.getText().toString()+"\n";
                if(pp.isChecked())
                    s=s+pp.getText().toString()+"\n";
                if(mp.isChecked())
                    s=s+mp.getText().toString()+"\n";
                if (s.equals(""))
                    Toast.makeText(MainActivity.this, "Select the items", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Your order has been placed successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}