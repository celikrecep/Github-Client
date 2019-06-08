package com.loyer.dagger.ui.main.di;

import android.content.Context;

import com.loyer.dagger.di.qualifiers.ActivityContext;
import com.loyer.dagger.di.qualifiers.ActivityScope;
import com.loyer.dagger.rx.clazz.ConnectionManagerImpl;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.ui.main.MainActivity;
import com.loyer.dagger.ui.main.MainActivityContainer;
import com.loyer.dagger.ui.main.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by celikrecep on 7.06.2019.
 */
@Module
public class MainActivityModule {
    @Provides
    @ActivityScope
    @ActivityContext
    Context provideActivityContext(MainActivity mainActivity){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivityContainer.Presenter<MainActivityContainer.View> provideMainActivityPresenter(
            MainActivityPresenter<MainActivityContainer.View> presenter
    ) {
        return presenter;
    }

    @Provides
    ConnectionManager provideConnectionManager(){
        return new ConnectionManagerImpl();
    }
}
