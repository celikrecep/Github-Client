package com.loyer.dagger.ui.repositories_list_fragment;

import com.loyer.dagger.base.common.BasePresenterImpl;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.rx.interfaces.ObservableListListener;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by celikrecep on 8.06.2019.
 */
@FragmentScope
public class RepositoriesListPresenter<V extends RepositoriesListContainer.View>
extends BasePresenterImpl<V, RepositoriesListInteractor> implements RepositoriesListContainer.Presenter<V> {

    @Inject
    public RepositoriesListPresenter(ConnectionManager connectionManager, RepositoriesListInteractor interactor) {
        super(connectionManager, interactor);
    }

    @Override
    public void onFetchRepositories(String username) {
        getInteractor().onFetchRepositories(username);
    }

    @Override
    public void subscribeConnections() {
        super.subscribeConnections();
        getInteractor().getModel().repositories.connect(new ObservableListListener<RepositoryResponse>() {
            @Override
            public void onDataInitial(List<RepositoryResponse> list) {
                getView().onRepositoriesLoaded(list);
            }

            @Override
            public void onDataAdded(List<RepositoryResponse> list) {

            }

            @Override
            public void onDataRemoved(List<RepositoryResponse> list, int position) {

            }

            @Override
            public void onDataUpdated(List<RepositoryResponse> list, int posiiton) {

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
