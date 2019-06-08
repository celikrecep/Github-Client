package com.loyer.dagger.di;

import android.app.Application;

import com.loyer.dagger.data_manager.di.NetworkModule;
import com.loyer.dagger.data_manager.prefs.di.SharedPrefModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by celikrecep on 7.06.2019.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        SharedPrefModule.class,
        ActivityBuilderModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
