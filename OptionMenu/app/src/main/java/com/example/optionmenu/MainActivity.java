package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText n1,n2;
TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=findViewById(R.id.pt1);
        n2=findViewById(R.id.pt2);
        res=findViewById(R.id.result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (n1.getText().toString().equals("") || n2.getText().toString().equals(""))
        {
            res.setText("Enter both the operands");
        }
        else
        {
            int a=Integer.parseInt(n1.getText().toString());
            int b=Integer.parseInt(n2.getText().toString());
            int operation=item.getItemId();
            int ans=0;
            switch(operation)
            {
                case R.id.add: ans=a+b;
                    res.setText(ans+"");
                    break;
                case R.id.sub: ans=a-b;
                    res.setText(ans+"");
                    break;
                case R.id.mul: ans=a*b;
                    res.setText(ans+"");
                    break;
                case R.id.div:
                    if (b==0)
                    {
                        res.setText("Division by zero error");
                    }
                    else {
                        ans = a / b;
                        res.setText(ans+"");
                    }
                    break;

            }
        }
        return super.onOptionsItemSelected(item);
    }

}