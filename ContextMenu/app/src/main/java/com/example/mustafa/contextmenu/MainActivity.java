package com.example.mustafa.contextmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list= (ListView) findViewById(R.id.list);
        String [] names=getResources().getStringArray(R.array.names);

        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);

        list.setAdapter(adapter);
        registerForContextMenu(list);




    }
    public void  onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_context,menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        TextView selectedItem=(TextView)menuInfo.targetView;
        TextView textView = (TextView) findViewById(R.id.durum);

        if(item.getItemId()==R.id.sil)
        {
            textView.setText(selectedItem.getText()+"için sil Tıklandı !");
            return  true;
        }
        if (item.getItemId()==R.id.duzenle)
        {
            textView.setText(selectedItem.getText()+"için Düzenle Tıklandi ! ");
            return true;
        }
        return false;

    }
}
