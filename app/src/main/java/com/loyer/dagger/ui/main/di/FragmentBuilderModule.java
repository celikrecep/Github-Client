package com.loyer.dagger.ui.main.di;

import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.ui.main.RootFragment;
import com.loyer.dagger.ui.repositories_list_fragment.RepositoriesListFragment;
import com.loyer.dagger.ui.username_fragment.UserInfoFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by celikrecep on 8.06.2019.
 */
@Module
public abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {FragmentsModule.class})
    abstract UserInfoFragment contributeUsernInfoFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {FragmentsModule.class})
    abstract RepositoriesListFragment contributeRepositoriesListFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {FragmentsModule.class})
    abstract RootFragment contributeRootFragmentInjector();
}
