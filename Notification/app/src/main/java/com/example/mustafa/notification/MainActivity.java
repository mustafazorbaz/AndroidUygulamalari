package com.example.mustafa.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });
    }
    public  void  notification()
    {
        NotificationCompat.Builder mBuilde=new NotificationCompat.Builder(this);
        mBuilde.setSmallIcon(R.drawable.notification_icon);
        mBuilde.setContentTitle("Notifcation Alert, Click Me !");
        mBuilde.setContentText("Hi, This is Android Notification Deatail !");

        Intent resulltIntent =new Intent(this,ResultActivity.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ResultActivity.class);

        stackBuilder.addNextIntent(resulltIntent);
        PendingIntent resultPendingIntent= stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilde.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,mBuilde.build());


    }
}
