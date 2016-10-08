package com.example.mustafazorbaz.listrunningapps;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.Process;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<App> appList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AppAdapter appAdapter;
    private EditText ilkDakika,sonDakika;
    TextView sayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        appAdapter = new AppAdapter(appList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(appAdapter);

        ilkDakika=(EditText) findViewById(R.id.kacSaniye) ;
        sayac=(TextView) findViewById(R.id.goster) ;


            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (ilkDakika.getText().toString().trim().isEmpty()){

                       AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                       alertDialog.setTitle("Uyarı");
                       alertDialog.setMessage("Lütfen Alanı Boş Geçmeyiniz");
                       alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                               new DialogInterface.OnClickListener() {
                                   public void onClick(DialogInterface dialog, int which) {
                                       dialog.dismiss();
                                   }
                               });
                       alertDialog.show();
                   }
                    else{
                        App app = appList.get(position);
                        Toast.makeText(MainActivity.this, "BAŞLANGIÇ = " + ilkDakika.getText(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, Servis.class);
                        intent.putExtra("ilkDk", Integer.parseInt(ilkDakika.getText().toString()));
                        intent.putExtra("process", app.getAppObject().processName);
                        startService(intent);

                        Toast.makeText(getApplicationContext(), app.getAppObject().processName + "--> is selected!", Toast.LENGTH_SHORT).show();
                        appAdapter.notifyDataSetChanged();

                        Intent intent2 = new Intent(MainActivity.this, Servis.class);
                        stopService(intent2);
                    }
                    new CountDownTimer(Integer.parseInt(ilkDakika.getText().toString())*1000, 1000) {//Toplam çalışma saniyesi ve en düşük saniye
                         public void onTick(long millisUntilFinished) {
                            sayac.setText("Kalan Süre : " + millisUntilFinished / 1000); //Saniyeyi bir bir düşürüp TextView'e setliyor.
                            //here you can have your logic to set text to edittext
                        }
                        public void onFinish() {
                            sayac.setText("Kalan Süre : 0");
                        }
                    }.start();
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));


        prepareAppData();

    }

    private void prepareAppData() {
        ActivityManager activityManager = (ActivityManager) this
                .getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> procInfos = activityManager
                .getRunningAppProcesses();
        for (int idx = 0; idx < procInfos.size(); idx++) {

            App apps = new App();
            apps.setAppName(procInfos.get(idx).processName);
            apps.setAppObject(procInfos.get(idx));
            Drawable icn = null;
            try {
                icn = getPackageManager().getApplicationIcon(procInfos.get(idx).processName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            apps.setIcon(icn);
            appList.add(apps);

        }
        appAdapter.notifyDataSetChanged();
    }


}