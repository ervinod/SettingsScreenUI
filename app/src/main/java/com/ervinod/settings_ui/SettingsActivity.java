package com.ervinod.settings_ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
    private Switch switchDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(new DarkModeManager(this).isNightMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        setContentView(R.layout.activity_settings);
        //function for enabling dark mode
        setDarkModeSwitch();
    }
    private void setDarkModeSwitch(){
        switchDarkMode = findViewById(R.id.darkModeSwitch);
        switchDarkMode.setChecked(new DarkModeManager(this).isNightMode());
        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DarkModeManager darkModeManager = new DarkModeManager(SettingsActivity.this);
                darkModeManager.setDarkMode(!darkModeManager.isNightMode());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
            }
        });
    }
}
