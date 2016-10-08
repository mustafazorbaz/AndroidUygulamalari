package com.example.mustafa.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.nfc.Tag;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by Mustafa on 22.5.2016.
 */
public class MyIntentService extends IntentService {
    private  static  final String TAG="MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) { //İntent Yüklendiği zaman devreye girecek olan metot
        final  int i=intent.getExtras().getInt("i",1);

        for (int j=0;j<i;j++){
            SystemClock.sleep(1000);
            Log.i(TAG,"Service running"+" "+j);
        }
    }
}

