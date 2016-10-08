package com.example.mustafa.preferencefragment;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends PreferenceActivity {

    @Override
    public void onBuildHeaders(List<Header> target) {
            loadHeadersFromResource(R.xml.preferenes,target);
    }
}
