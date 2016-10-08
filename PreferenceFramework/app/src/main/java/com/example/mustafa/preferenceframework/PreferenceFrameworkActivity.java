package com.example.mustafa.preferenceframework;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Mustafa on 23.5.2016.
 */
public class PreferenceFrameworkActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
