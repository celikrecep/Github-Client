package com.loyer.dagger.ui;



import com.loyer.dagger.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by celikrecep on 7.06.2019.
 */
public class BaseApp extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build() ;
    }
}
