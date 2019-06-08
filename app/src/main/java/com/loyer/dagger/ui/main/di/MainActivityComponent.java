package com.loyer.dagger.ui.main.di;

import com.loyer.dagger.di.qualifiers.ActivityScope;
import com.loyer.dagger.ui.main.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by celikrecep on 7.06.2019.
 */
@ActivityScope
@Subcomponent(modules = {MainActivityModule.class, FragmentBuilderModule.class})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
