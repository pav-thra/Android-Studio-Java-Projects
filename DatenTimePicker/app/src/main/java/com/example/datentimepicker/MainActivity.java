package com.example.datentimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Button db,tb;
EditText dt,tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=findViewById(R.id.date_b);
        tb=findViewById(R.id.time_b);
        dt=findViewById(R.id.date_pt);
        tt=findViewById(R.id.time_pt);

        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                int y,m,day;
                y=c.get(Calendar.YEAR);
                m=c.get(Calendar.MONTH);
                day=c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dp=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dt.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                }, y, m, day);
                dp.show();
            }
        });

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                int hr,min;
                hr=c.get(Calendar.HOUR);
                min=c.get(Calendar.MINUTE);

                TimePickerDialog tp=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String s=i+"";
                        if (s.length()==1)
                            s="0"+s;
                        tt.setText(s+":"+i1);
                    }
                }, hr, min, true);
                tp.show();
            }
        });
    }
}