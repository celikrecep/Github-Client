package com.loyer.dagger.ui.repositories_list_fragment;

import com.loyer.dagger.base.common.BaseInteractorImpl;
import com.loyer.dagger.data_manager.RequestListener;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.data_manager.service.Service;
import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.rx.interfaces.ConnectionTracker;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by celikrecep on 8.06.2019.
 */
@FragmentScope
public class RepositoriesListInteractor extends BaseInteractorImpl<RepositoriesListData> {

    private Service service;

    @Inject
    public RepositoriesListInteractor(RepositoriesListData model, ConnectionManager connectionManager, Service service) {
        super(model, connectionManager);
        this.service = service;
    }

    @Override
    public void removeAllConnections() {
        super.removeAllConnections();
    }

    @Override
    public RepositoriesListData getModel() {
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
                getModel().repositories.refreshData(response);
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
