package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.example.project1.databinding.ActivitySettingsBinding;

public class SettingsActivity extends BaseActivity {
    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
        
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);
			
			ListPreference nightMode = findPreference("night_mode");
			nightMode.setOnPreferenceChangeListener((prefs, newValue) -> {
				ThemeHelper.apply((String) newValue);
				reload(requireActivity());
				return true;
			});
			
			SwitchPreferenceCompat amoledMode = findPreference("amoled_mode");
			amoledMode.setEnabled(ThemeHelper.isNightMode(requireContext()));
			amoledMode.setOnPreferenceChangeListener((prefs, newValue) -> {
				reload(requireActivity());
				return true;
			});
        }
        
        private void reload(Activity activity) {
			Bundle savedInstanceState = new Bundle();
			activity.onSaveInstanceState(savedInstanceState, null);
        	activity.finish();
            Intent intent = new Intent(activity, SettingsActivity.class);
            activity.startActivity(intent);
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}
