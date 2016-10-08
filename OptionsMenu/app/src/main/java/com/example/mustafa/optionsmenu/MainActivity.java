package com.example.mustafa.optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView=(TextView) findViewById(R.id.text1);

        switch (item.getItemId()){
            case R.id.geridon:textView.setText("Geri Dön Tıklandı");
                return  true;
            case R.id.guncelle:
                textView.setText("Güncelle  Tıklandi");
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }

    }
}
