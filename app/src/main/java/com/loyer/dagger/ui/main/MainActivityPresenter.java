package com.loyer.dagger.ui.main;

import com.loyer.dagger.base.common.BasePresenterImpl;
import com.loyer.dagger.di.qualifiers.ActivityScope;
import com.loyer.dagger.rx.interfaces.ConnectionManager;

import javax.inject.Inject;

/**
 * Created by celikrecep on 7.06.2019.
 */
@ActivityScope
public class MainActivityPresenter<V extends MainActivityContainer.View>
extends BasePresenterImpl<V, MainActivityInteractor> implements MainActivityContainer.Presenter<V> {

    @Inject
    public MainActivityPresenter(ConnectionManager connectionManager, MainActivityInteractor interactor) {
        super(connectionManager, interactor);
    }

    @Override
    public void onFetchRepositories(String username) {
        getInteractor().onFetchRepositories(username);
    }
}
