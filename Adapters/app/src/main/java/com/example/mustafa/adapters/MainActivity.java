package com.example.mustafa.adapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final List<CharSequence> cities = getCities();
        final ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        Button buttonKaydet = (Button) findViewById(R.id.kaydetButton);
        final EditText sehirEditText = (EditText) findViewById(R.id.sehirEditText);
        final TextView durumTextView = (TextView) findViewById(R.id.durumTextView);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sehirAdi = sehirEditText.getText().toString();
                cities.add(sehirAdi);
                adapter.notifyDataSetChanged();
                sehirEditText.setText("");
                durumTextView.setText(sehirAdi + " " + "Eklendi !");
            }
        });

    }
    private  List<CharSequence> getCities(){

        List<CharSequence> cities=new ArrayList<CharSequence>();
        cities.add("istanbul");
        cities.add("Antalya");
        cities.add("Mugla");
        cities.add("Ankara");
        return  cities;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
