package com.example.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm ! Wake Up ! Wake Up !",Toast.LENGTH_LONG).show();
        Uri alarmURI =RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alarmURI==null){
            alarmURI=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        }
        Ringtone ringtone=RingtoneManager.getRingtone(context,alarmURI);
        ringtone.play();


    }
}
