package com.loyer.dagger.data_manager.prefs.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.loyer.dagger.data_manager.prefs.SharedPref;
import com.loyer.dagger.data_manager.prefs.SharedPrefImpl;
import com.loyer.dagger.di.qualifiers.ApplicationContext;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by celikrecep on 8.06.2019.
 */
@Module
public class SharedPrefModule {
    private static final String SHARED_PREFERENCES = "shared_preferences";
    @Named(SHARED_PREFERENCES)
    @Provides
    String provideBaseUrl() {
        return "dagger_example";
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(@ApplicationContext Context context,
                                               @Named(SHARED_PREFERENCES) String sharedPref){
        return context.getSharedPreferences(sharedPref, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    SharedPref provideSharedPrefManager(SharedPrefImpl sharedPrefManager){
        return sharedPrefManager;
    }
}
