package com.example.project1;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		ThemeHelper.apply(this);
        setTheme(isAmoledEnabled() ? R.style.AppTheme_Black : R.style.AppTheme);
        super.onCreate(savedInstanceState);
    }
    

    private boolean isAmoledEnabled() {
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        return prefs.getBoolean("amoled_mode", false);
    }
}
