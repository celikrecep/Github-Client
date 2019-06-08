package com.loyer.dagger.ui.username_fragment;

import com.loyer.dagger.base.common.BasePresenterImpl;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;
import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.rx.interfaces.ObservableDataListener;

import javax.inject.Inject;

/**
 * Created by celikrecep on 8.06.2019.
 */
@FragmentScope
public class UserInfoPresenter<V extends UserInfoContainer.View>
extends BasePresenterImpl<V, UserInfoInteractor> implements UserInfoContainer.Presenter<V> {

    @Inject
    public UserInfoPresenter(ConnectionManager connectionManager, UserInfoInteractor interactor) {
        super(connectionManager, interactor);
    }

    @Override
    public void onFetchUser(String username) {
        getInteractor().onFetchUserInfo(username);
    }

    @Override
    public void subscribeConnections() {
        super.subscribeConnections();
        getInteractor().getModel().response.connect(new ObservableDataListener<UserResponse>() {
            @Override
            public void onDataChanged(UserResponse data) {
                getView().onUserLoaded(data);
            }
            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
