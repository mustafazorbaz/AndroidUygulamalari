package com.example.mustafa.preferencefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Mustafa on 23.5.2016.
 */
public class DisplaySettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.display_preferences);
    }
}
