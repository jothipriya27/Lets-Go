package com.example.mukesh.letsgo;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button button12=(Button)findViewById(R.id.button12);
        Button button13=(Button)findViewById(R.id.button13);
        Button button11=(Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main4Activity.this,Main6Activity.class);
                startActivity(intent);
            }
        });
        final EditText editText7=(EditText)findViewById(R.id.editText7);
        final EditText editText10=(EditText)findViewById(R.id.editText10);
        button12.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Dialog setDate = new Dialog(Main4Activity.this);
                setDate.requestWindowFeature(Window.FEATURE_NO_TITLE);
                setDate.setContentView(R.layout.dialog_setdate);
                setDate.show();
                DatePicker date = (DatePicker) setDate.findViewById(R.id.datePicker);
                date.setMinDate(System.currentTimeMillis() - 1000);
                Calendar calender = Calendar.getInstance();

                DatePicker.OnDateChangedListener onDateChangedListener = new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
                        int day = dayOfMonth;
                        int year = years;
                        int month = monthOfYear;
                        setDate.dismiss();
                        editText7.setText(day + "-" + (month + 1) + "-" + year);
                    }
                };

                int day = calender.get(Calendar.DAY_OF_MONTH);
                int month = calender.get(Calendar.MONTH);
                int year = calender.get(Calendar.YEAR);

                date.init(year, month, day, onDateChangedListener);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Main4Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        editText10.setText(selectedHour + ":" + selectedMinute);
                    }
                },hour, minute,false);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
    }
}
