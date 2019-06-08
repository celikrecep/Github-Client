package com.loyer.dagger.ui.username_fragment;

import com.loyer.dagger.base.common.BaseInteractorImpl;
import com.loyer.dagger.data_manager.RequestListener;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;
import com.loyer.dagger.data_manager.service.Service;
import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.rx.interfaces.ConnectionTracker;

import javax.inject.Inject;

/**
 * Created by celikrecep on 8.06.2019.
 */
@FragmentScope
public class UserInfoInteractor extends BaseInteractorImpl<UserInfoData> {

    private Service service;

    @Inject
    public UserInfoInteractor(UserInfoData model, ConnectionManager connectionManager, Service service) {
        super(model, connectionManager);
        this.service = service;
    }

    @Override
    public void removeAllConnections() {
        super.removeAllConnections();
    }

    @Override
    public UserInfoData getModel() {
        return super.getModel();
    }

    public void onFetchUserInfo(String username) {
        service.onFetchUser(new RequestListener<UserResponse>() {
            @Override
            public void onRequestSend(ConnectionTracker tracker) {
                addConnection(tracker);
            }

            @Override
            public void onResponseCome(UserResponse response) {
                getModel().response.postValue(response);
            }

            @Override
            public void onRequestError(Throwable error) {
            }

            @Override
            public void onRequestCompleted() {
            }
        }, username);
    }
}
