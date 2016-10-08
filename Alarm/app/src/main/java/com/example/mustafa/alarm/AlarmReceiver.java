package com.example.mustafa.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Toast;

/**
 * Created by Mustafa on 22.5.2016.
 */
public class AlarmReceiver  extends BroadcastReceiver{
    public  static int sayi=1;
    @Override
    public void onReceive(Context context, Intent intent) {
        long time=  SystemClock.elapsedRealtime();
        Toast.makeText(context,"Alarm ="+" "+sayi,Toast.LENGTH_SHORT).show();
    sayi++;
    }
}
