package com.example.mustafa.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStopRepartAlarm,btnStarRepartAlarm;
    private  static final  int BES_SANIYE=5*1000; // 5 saniye
    private AlarmManager manager;
    private PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent=new Intent(MainActivity.this,AlarmReceiver.class);
        pendingIntent =PendingIntent.getBroadcast(MainActivity.this,0,alarmIntent,0);

        Button btnStarRepartAlarm=(Button)findViewById(R.id.buttonStartRepartAlarm);
        Button btnStopRepartAlarm=(Button)findViewById(R.id.buttonStopRepartAlarm);

        btnStarRepartAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,BES_SANIYE,BES_SANIYE,pendingIntent);

            }
        });

        btnStopRepartAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.cancel(pendingIntent);
            }
        });

    }
}
