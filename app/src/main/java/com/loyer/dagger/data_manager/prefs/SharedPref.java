package com.loyer.dagger.data_manager.prefs;

import javax.inject.Singleton;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface SharedPref {
    void saveUserName(String username);
    String getUsername();
}
