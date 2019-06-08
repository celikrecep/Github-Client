package com.loyer.dagger.di;

import android.app.Application;
import android.content.Context;

import com.loyer.dagger.di.qualifiers.ApplicationContext;

import dagger.Binds;
import dagger.Module;

/**
 * Created by celikrecep on 7.06.2019.
 */
@Module
public abstract class AppModule {
    @Binds
    @ApplicationContext
    abstract Context bindContext(Application application);
}
