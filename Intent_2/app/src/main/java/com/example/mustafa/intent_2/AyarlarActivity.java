package com.example.mustafa.intent_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Mustafa on 22.5.2016.
 */
public class AyarlarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayarlar);

       /* Bundle extras2=getIntent().getExtras();
        if(extras2!=null)
        {
            String mesaj2=extras2.getString("main");
            Toast.makeText(AyarlarActivity.this,mesaj2,Toast.LENGTH_SHORT).show();
        }*/
        Button button =(Button) findViewById(R.id.buttonMain) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AyarlarActivity.this,MainActivity.class);
                intent.putExtra("ayarlar","Bu Mainden Geldi");
                startActivity(intent);
            }
        });

    }
}
