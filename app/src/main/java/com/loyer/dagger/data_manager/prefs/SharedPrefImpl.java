package com.loyer.dagger.data_manager.prefs;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by celikrecep on 8.06.2019.
 */
@Singleton
public class SharedPrefImpl implements SharedPref {
    private static String USERNAME = "username";
    private SharedPreferences sharedPref;

    @Inject
    public SharedPrefImpl(SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
    }

    @Override
    public void saveUserName(String username) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USERNAME, username).apply();
    }
}
