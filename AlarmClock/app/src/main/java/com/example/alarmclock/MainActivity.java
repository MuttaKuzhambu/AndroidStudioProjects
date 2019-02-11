package com.example.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TimePicker alarmTimePicker;
PendingIntent pendingIntent;
AlarmManager alarmManager;
ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTimePicker=(TimePicker) findViewById(R.id.timePicker);
        alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        tb=(ToggleButton )findViewById(R.id.toggleButton);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time;
                if(((ToggleButton)v).isChecked()){
                    Toast.makeText(MainActivity.this,"ALARM ON",Toast.LENGTH_SHORT).show();
                    Calendar calendar=Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getCurrentHour());
                    calendar.set(Calendar.MINUTE,alarmTimePicker.getCurrentMinute());
                    Intent intent=new Intent(MainActivity.this,AlarmReceiver.class);
                    pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
                    time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%6000));
                    if(System.currentTimeMillis()>time){
                        if(calendar.AM_PM==0)
                            time+=(1000*60*60*12);
                        else
                            time+=(1000*60*60*24);

                    }
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,time,10000,pendingIntent);
                }
                else{
                    alarmManager.cancel(pendingIntent);
                    Toast.makeText(MainActivity.this,"ALARM OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
