package com.example.mustafa.interneterisimi;

import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    private  static  final String TAG="DovizTakip";
    private List<String> dovizOranList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dovizOranList =getDovizOranList();
        adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dovizOranList);
        ListView dovizOranListViewListView=(ListView)findViewById(R.id.listView);
        dovizOranListViewListView.setAdapter(adapter);

        Button btnYenile=(Button) findViewById(R.id.buttonYenile);
        btnYenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dovizOranList=getDovizOranList();
                adapter.notifyDataSetChanged();
            }
        });

    }
    private List<String> getDovizOranList(){
        HttpURLConnection httpURLConnection=null;
        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            URL url=new URL(getResources().getString(R.string.doviz_takip_url));
            httpURLConnection=(HttpURLConnection) url.openConnection();

            int sonucKodu=httpURLConnection.getResponseCode();
            if(sonucKodu==HttpURLConnection.HTTP_OK){
                BufferedInputStream stream=new BufferedInputStream(httpURLConnection.getInputStream());
                return  getDovizOranListFromInputStream(stream);
            }

        }
        catch (Exception e){
            Log.d(TAG,"HTTP bağlantısı kurulurken hata oluştu",e);
        }finally {
            if (httpURLConnection!=null)
                httpURLConnection.disconnect();
        }
        return new ArrayList<String>();
    }
    private  List<String> getDovizOranListFromInputStream(BufferedInputStream stream){
        List<String> dovizOranList=new ArrayList<String>();
        if(stream==null)
            return dovizOranList;

        try{
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document =documentBuilder.parse(stream);

            Element firstCube=(Element) document.getElementsByTagName("Cube").item(0);
            Element  seconCube=(Element) firstCube.getElementsByTagName("Cube").item(0);

            NodeList dovOranNodeList =seconCube.getElementsByTagName("Cube");

            for(int i=0;i<dovOranNodeList.getLength();i++ ){
                Element dovizOranElement=(Element) dovOranNodeList.item(i);
                String paraBirimi =dovizOranElement.getAttribute("currency");
                String euroyaOrani=dovizOranElement.getAttribute("rate");

                dovizOranList.add(paraBirimi+" / € = "+euroyaOrani);
            }
        }
        catch (Exception e){
            Log.d(TAG,"XML");
        }
        return  dovizOranList;
    }
}
