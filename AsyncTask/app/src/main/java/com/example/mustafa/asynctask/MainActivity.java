package com.example.mustafa.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private  DovizTakipAsyncTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task =new DovizTakipAsyncTask(this);
        task.execute(getResources().getString(R.string.doviz_takip_url));

        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task=new DovizTakipAsyncTask(MainActivity.this);
                task.execute(getResources().getString(R.string.doviz_takip_url));
            }
        });

    }
}
