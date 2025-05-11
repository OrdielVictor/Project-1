package com.example.project1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

public class ThemeHelper {
    
    public static void apply(Context context) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		apply(prefs.getString("night_mode", NightMode.SYSTEM));
	}

    public static void apply(String nightMode) {
		int defaultNightMode = switch (nightMode) {
			case NightMode.OFF -> AppCompatDelegate.MODE_NIGHT_NO;
			case NightMode.ON -> AppCompatDelegate.MODE_NIGHT_YES;
			default -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
		};
		AppCompatDelegate.setDefaultNightMode(defaultNightMode);
	}

    public static boolean isNightMode(Context context) {
		int nightModeFlag = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
		return nightModeFlag == Configuration.UI_MODE_NIGHT_YES;
	}
}
