package io.carpoolapp.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import io.carpoolapp.models.User;

/**
 * Created by akshay on 11-12-2018.
 */

public class SharedPreferencesManager implements UserSettings {

    String str = "commit 13";
    private static final String KEY_USER = "user";
    private static final String IS_USER_LOGGED_IN = "is_user_logged_in";
    private final SharedPreferences preferences;
    private static SharedPreferencesManager instance;
    private Gson gson = new Gson();


    private SharedPreferencesManager(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public boolean isUserLoggedIn() {
        return preferences.getBoolean(IS_USER_LOGGED_IN, false);
    }

    public void setUserLoggedIn(boolean isUserLoggedIn) {
        preferences.edit().putBoolean(IS_USER_LOGGED_IN, isUserLoggedIn).apply();
    }

    @Override
    public User getAppUser() {
        String json = preferences.getString(KEY_USER, null);
        return gson.fromJson(json, User.class);
    }

    public static UserSettings getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesManager(context);
        }
        return instance;
    }
}
