package com.example.mustafazorbaz.restfulwebservice;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewpagerindicator.TitlePageIndicator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter adapter;
    private static final String TAG = "SONUÇ ========";

    TextView tvIsConnected;
    ProgressDialog dialog;

    JSONObject jsonResult;

    private String CITY = "izmir";
    private String COUNTRY = "Turkey";
    Query query = new Query();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get reference to the views
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);
        viewPager = (ViewPager) findViewById(R.id.pager);


        //Controling internet
        if (isConnected()) {
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are conncted");
        } else {
            tvIsConnected.setText("You are NOT conncted");
        }


        // call AsynTask to perform network operation on separate thread
        new HttpAsyncTask().execute("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" + CITY + "%2C%20" + COUNTRY + "%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");

        //Bind the title indicator to the adapter




    }

    public boolean isConnected() {//we can  do if we  want to colouring(Renklendirmek için yapabiliriz)
        //Created for İnternet Connection Manager(İnternet bağlantısı için ekledik.)
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);

        //We have received information from the network connection manager.(Bağlantı yöneticisinden ağ bilsini aldık)
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // true if there is an internet connection.(İnternet bağlı ise true )
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else//if not =false
            return false;
    }

    //
    public String GET(String url) {


        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient(HttpClient yarattık)
            HttpClient httpclient = new DefaultHttpClient();
            // make GET request to the given URL(Verilen URL için GET isteği yaptık)
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            // receive response as inputStream(intputStream olarak istek alınır)
            inputStream = httpResponse.getEntity().getContent();
            // convert inputstream to string(inputStream'i String'e dönüştür)
            if (inputStream != null) {
                result = convertInputStreamToString(inputStream);

                Log.v(TAG, result);

            } else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        //We add buffer reader to read(bufferedRead e okumak için interStream ekledik)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)//We read  line by line(Satır satır okuduk)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.


        @Override
        protected void onPreExecute() {

            dialog = ProgressDialog.show(MainActivity.this, null, "Yukleniyor, lutfen bekleyiniz", true);
            dialog.show();
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != "") {
                Toast.makeText(getBaseContext(), "Başarılı", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            ObjectMapper mapper = new ObjectMapper(); // create once, reuse
            // Query query1=new Query();

            try {
                jsonResult = new JSONObject(result);
                String finalResult = jsonResult.getJSONObject("query").toString();
                 query = mapper.readValue(finalResult, Query.class);

                // Pass results to ViewPagerAdapter Class
                adapter = new ViewPagerAdapter(MainActivity.this,query,CITY,COUNTRY);
                // Binds the Adapter to the ViewPager
                viewPager.setAdapter(adapter);

                //for Indicator
                TitlePageIndicator titleIndicator = (TitlePageIndicator)findViewById(R.id.titles);
                titleIndicator.setViewPager(viewPager);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}