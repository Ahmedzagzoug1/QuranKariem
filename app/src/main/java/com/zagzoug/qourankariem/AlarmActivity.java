package com.zagzoug.qourankariem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {
 TimePicker timePicker;
 int hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

 timePicker= (TimePicker) findViewById(R.id.alarm);


    }

    public void setAlarm(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour= timePicker.getHour();
            minute=timePicker.getMinute();
        }else {

            hour = timePicker.getCurrentHour();
            minute = timePicker.getCurrentMinute();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 5);
        AlarmManager am = (AlarmManager)   getSystemService  (Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReciever.class);

        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_HALF_HOUR, pi);
     }

}
