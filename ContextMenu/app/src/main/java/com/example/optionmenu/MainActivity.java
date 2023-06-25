package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        registerForContextMenu(res); //added

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//added
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) { //added
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
        return super.onContextItemSelected(item);
    }
}