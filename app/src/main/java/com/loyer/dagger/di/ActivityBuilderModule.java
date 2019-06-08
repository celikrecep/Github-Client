package com.loyer.dagger.di;

import com.loyer.dagger.ui.main.MainActivity;
import com.loyer.dagger.ui.main.di.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * Created by celikrecep on 7.06.2019.
 */
@Module(subcomponents = MainActivityComponent.class)
abstract class ActivityBuilderModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> contributeMainActivityInjector(MainActivityComponent.Builder builder);
}
