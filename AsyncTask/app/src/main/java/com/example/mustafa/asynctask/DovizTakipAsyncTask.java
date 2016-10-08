package com.example.mustafa.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Mustafa on 22.5.2016.
 */
public class DovizTakipAsyncTask extends AsyncTask<String,String,List<String>> {
    private  static  final String TAG="DovizTakipAsyncTask";
    private Context context;
    private ListView dovizOranListView;
    private ProgressDialog progressDialog;
    private ArrayAdapter<String> adapter;

    public  DovizTakipAsyncTask(Context context){
        super();
        this.context=context;
        dovizOranListView=(ListView)((Activity)context).findViewById(R.id.listView);

    }
    protected  void  onPreExecute()
    {
        progressDialog=ProgressDialog.show(context,"Lütfen Bekleyiniz...","İşlem Yürütülüyor...",true);
    }
    protected List<String> doInBackground(String... params )
    {
        return getDovizOranList(params[0]);
    }
    private  List<String> getDovizOranList(String dovizTakipUrl){
        HttpURLConnection urlConnection=null;
        try {
            publishProgress("HTTP Bağlantısı kuruluyor...");

            //	URL CONNECTİON
            URL url=new URL(dovizTakipUrl);
            urlConnection=(HttpURLConnection) url.openConnection();

            int sonucKodu=urlConnection.getResponseCode();


            if(sonucKodu==HttpURLConnection.HTTP_OK){
                BufferedInputStream stream=new BufferedInputStream(urlConnection.getInputStream());

                publishProgress("Döviz oranları okunuyor...");
                List<String> dovizOranList=getDovizOranListFromInputStream(stream);

                publishProgress("Liste güncelleniyor...");
                return dovizOranList;
            }

        }catch(Exception e){
            Log.d(TAG,"HTTP bağlantısı kurulurken hata oluştu",e);
        }finally {
            if(urlConnection!=null)
                urlConnection.disconnect();
        }
        return  new ArrayList<String>();
    }



    public List<String> getDovizOranListFromInputStream(BufferedInputStream stream){
        List<String> dovizOranList=new ArrayList<String>();
        if (stream==null)
            return dovizOranList;

        try {
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document=documentBuilder.parse(stream);
            Element firtCube=(Element) document.getElementsByTagName("Cube").item(0);
            Element secondCube=(Element)firtCube.getElementsByTagName("Cube").item(0);

            NodeList  dovizOranNodeList=secondCube.getElementsByTagName("Cube");
            int dovizOranNodeListLength=dovizOranNodeList.getLength();
            for (int i=0;i<5;i++){
                Random random=new Random();
                int rasgeleSayi=random.nextInt(dovizOranNodeListLength);

                Element dovizOranElement=(Element) dovizOranNodeList.item(rasgeleSayi);
                String paraBirimi=dovizOranElement.getAttribute("currency");
                String euroyaOrani=dovizOranElement.getAttribute("rate");

                dovizOranList.add(paraBirimi+" / € = "+euroyaOrani);
            }

        }catch (Exception e){
            Log.d(TAG,"XML parse edilirken hata oluştu",e);
        }

        return  dovizOranList;
                
    }
    protected  void onProgressUpdate(String... progress){
        progressDialog.setMessage(progress[0]);
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,strings);
        dovizOranListView.setAdapter(adapter);
        progressDialog.cancel();
    }
}
