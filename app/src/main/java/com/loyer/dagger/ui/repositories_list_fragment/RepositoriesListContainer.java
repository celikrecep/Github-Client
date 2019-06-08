package com.loyer.dagger.ui.repositories_list_fragment;

import com.loyer.dagger.base.interfacezz.BaseFragmentView;
import com.loyer.dagger.base.interfacezz.BasePresenter;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;

import java.util.List;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface RepositoriesListContainer {
    interface View extends BaseFragmentView {
        void onRepositoriesLoaded(List<RepositoryResponse> repositories);
    }

    interface Presenter<V extends View> extends BasePresenter<V, RepositoriesListInteractor> {
        void onFetchRepositories(String username);
    }
}
