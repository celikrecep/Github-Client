package com.loyer.dagger.ui.main;

import com.loyer.dagger.base.common.BaseInteractorImpl;
import com.loyer.dagger.base.interfacezz.BaseInteractor;
import com.loyer.dagger.data_manager.RequestListener;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.data_manager.service.Service;
import com.loyer.dagger.di.qualifiers.ActivityScope;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.rx.interfaces.ConnectionTracker;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by celikrecep on 7.06.2019.
 */
@ActivityScope
public class MainActivityInteractor extends BaseInteractorImpl<MainActivityData> {

    private Service service;

    @Inject
    public MainActivityInteractor(MainActivityData model, ConnectionManager connectionManager, Service service) {
        super(model, connectionManager);
        this.service = service;
    }

    @Override
    public void removeAllConnections() {
        super.removeAllConnections();
    }

    @Override
    public MainActivityData getModel() {
        return super.getModel();
    }

    public void onFetchRepositories(String username) {
        service.onFetchRepositories(new RequestListener<List<RepositoryResponse>>() {
            @Override
            public void onRequestSend(ConnectionTracker tracker) {
                    addConnection(tracker);
            }

            @Override
            public void onResponseCome(List<RepositoryResponse> response) {
                getModel().repositories.addAll(response);
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
