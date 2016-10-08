package com.example.mustafa.servis;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

/**
 * Created by Mustafa on 22.5.2016.
 */
public class MyService extends Service{

    private  static  final String TAG="MyService";
    private  boolean isRunning=false;
    public  MyService(){

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"Service onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"Service onCreate");
        isRunning=true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        //1000 mili saniyede bir servis çalıştığının mesajını verir ve 5 kez bunu tekrarlar.
        Log.i(TAG,"Service onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    if (isRunning){
                        Log.i(TAG,"Service Running");
                    }
                }

            }
        }).start();
        return  Service.START_STICKY;
    }

    @Override
    public void onDestroy() {

        isRunning=false;
        Log.i(TAG,"Service onDestory");
    }
}
