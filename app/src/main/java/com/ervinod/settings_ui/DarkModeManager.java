package com.ervinod.settings_ui;

/**
 * Created by kapil on 20/01/17.
 */
import android.content.Context;
import android.content.SharedPreferences;


public class DarkModeManager {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context _context;

    // shared preference mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "settings_prefs";

    private static final String IS_NIGHT_MODE = "IsNightMode";


    public DarkModeManager(Context context) {
        this._context = context;
        preferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setDarkMode(boolean isFirstTime) {
        editor.putBoolean(IS_NIGHT_MODE, isFirstTime);
        editor.commit();
    }

    public boolean isNightMode() {
        return preferences.getBoolean(IS_NIGHT_MODE, true);
    }

}