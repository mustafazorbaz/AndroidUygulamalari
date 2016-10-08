package com.example.mustafazorbaz.listrunningapps;
import android.app.IntentService;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;


public class Servis extends IntentService {
    private static final String TAG = "MyIntentService";
    public Servis() {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        final int ilk= intent.getExtras().getInt("ilkDk",1);
        final String process = intent.getExtras().getString("process");

        Toast.makeText(Servis.this,"process = "+process, Toast.LENGTH_SHORT).show();
        for (int j=0; j < ilk; j++) {
            SystemClock.sleep(1000);
            Log.i(TAG, "Service running" + " " + j);
        }
        Intent intent2=getPackageManager().getLaunchIntentForPackage(process);
        startActivity(intent2);
    }
}

