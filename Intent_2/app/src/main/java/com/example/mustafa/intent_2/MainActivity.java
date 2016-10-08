package com.example.mustafa.intent_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            String mesaj=extras.getString("ayarlar");
            Toast.makeText(MainActivity.this,mesaj,Toast.LENGTH_SHORT).show();
        }
        Button button =(Button) findViewById(R.id.buttonAyarlar) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AyarlarActivity.class);
                intent.putExtra("main","Bu Mainden Geldi");
                startActivity(intent);
            }
        });

        Button buttonAra =(Button) findViewById(R.id.buttonArama) ;
        buttonAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(Intent.ACTION_DIAL);
                ıntent.setData(Uri.parse("tel:533-333-3333"));
                startActivity(ıntent);
            }
        });
    }
}
