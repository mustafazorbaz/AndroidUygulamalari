package com.example.mustafa.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Mustafa on 3.4.2016.
 */
public class TsunamiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message=intent.getStringExtra("Mesaj");
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();

    }
}
