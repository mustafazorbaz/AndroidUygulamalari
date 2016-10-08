package com.example.mustafazorbaz.restfulwebservice;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SONUÇ ========";
    TextView etResponse;
    TextView tvIsConnected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get reference to the views
        etResponse = (TextView) findViewById(R.id.etResponse);
        etResponse.setMovementMethod(new ScrollingMovementMethod());
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);
        if (isConnected()) {
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are conncted");
        }else{
            tvIsConnected.setText("You are NOT conncted");
        }

       // new HttpAsyncTask().execute("http://hmkcode.appspot.com/rest/controller/get.json");
        // call AsynTask to perform network operation on separate thread
        new HttpAsyncTask().execute("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
    }

    public boolean isConnected(){
        //Added
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
    }
    public String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
            // convert inputstream to string
            if(inputStream != null){
                result = convertInputStreamToString(inputStream);
                etResponse.setText(result);
                Log.v(TAG,result);
            }
            else
                result = "Did not work!";
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return result;
    }
    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

        // onPostExecute displays the results of the AsyncTask.

        /*
        // @Override
          protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            try {
                JSONObject json = new JSONObject(result);

                String str = "";

                JSONArray articles = json.getJSONArray("forecast");

                str += "forecast length = "+json.getJSONArray("forecast").length();
                str += "\n--------\n";
                str += "names: "+articles.getJSONObject(0).names();
                str += "\n--------\n";
                str += "url: "+articles.getJSONObject(0).getString("url");

                etResponse.setText(str);
                //etResponse.setText(json.toString(1));

            } catch (JSONException e) {

                e.printStackTrace();
            }
        }
        */

}
