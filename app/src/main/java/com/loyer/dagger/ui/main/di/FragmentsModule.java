package com.loyer.dagger.ui.main.di;

import android.content.Context;

import com.loyer.dagger.di.qualifiers.ActivityContext;
import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.rx.clazz.ConnectionManagerImpl;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.ui.repositories_list_fragment.RepositoriesListContainer;
import com.loyer.dagger.ui.repositories_list_fragment.RepositoriesListPresenter;
import com.loyer.dagger.ui.repositories_list_fragment.adapter.RepositoriesListAdapter;
import com.loyer.dagger.ui.username_fragment.UserInfoContainer;
import com.loyer.dagger.ui.username_fragment.UserInfoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by celikrecep on 8.06.2019.
 */
@Module
public class FragmentsModule {

    @FragmentScope
    @Provides
    public UserInfoContainer.Presenter<UserInfoContainer.View> provideUserInfoPresenter(
            UserInfoPresenter<UserInfoContainer.View> presenter
    ) {
        return presenter;
    }

    @FragmentScope
    @Provides
    public RepositoriesListContainer.Presenter<RepositoriesListContainer.View> provideRepositoriesListPresenter(
            RepositoriesListPresenter<RepositoriesListContainer.View> presenter
    ) {
        return presenter;
    }

    @FragmentScope
    @Provides
    @ActivityContext
    public RepositoriesListAdapter provideRepositoriesListAdapter(Context context) {
        return new RepositoriesListAdapter(context);
    }
}
