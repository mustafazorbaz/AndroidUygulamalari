package com.example.mustafa.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        final List<CharSequence> cities=getCities();
        final ArrayAdapter<CharSequence> adapter=new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item,cities);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        Button buttonKaydet=(Button)findViewById(R.id.button);
        final EditText sehir=(EditText) findViewById(R.id.editText);
        final TextView durum=(TextView) findViewById(R.id.editText);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sehirAdi=sehir.getText().toString();
                cities.add(sehirAdi);
                adapter.notifyDataSetChanged();
                durum.setText(sehirAdi+"--> Eklendi");
            }
        });


    }
    private List<CharSequence> getCities()
    {
        List<CharSequence> cities=new ArrayList<CharSequence>();
        cities.add("Ankara");
        cities.add("Izmir");
        cities.add("Istanbul");
        cities.add("Mugla");
        return cities;
    }
}
