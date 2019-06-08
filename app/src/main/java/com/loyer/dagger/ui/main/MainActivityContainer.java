package com.loyer.dagger.ui.main;

import com.loyer.dagger.base.interfacezz.BaseFragmentView;
import com.loyer.dagger.base.interfacezz.BasePresenter;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;

import java.util.List;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface MainActivityContainer {
    interface View extends BaseFragmentView {
        void onRepositoriesLoaded(List<RepositoryResponse> repositories);
    }

    interface Presenter<V extends View> extends BasePresenter<V, MainActivityInteractor> {
        void onFetchRepositories(String username);
    }
}
