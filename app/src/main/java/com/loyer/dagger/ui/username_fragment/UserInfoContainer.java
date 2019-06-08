package com.loyer.dagger.ui.username_fragment;

import com.loyer.dagger.base.interfacezz.BaseFragmentView;
import com.loyer.dagger.base.interfacezz.BasePresenter;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;
import com.loyer.dagger.ui.main.MainActivityInteractor;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface UserInfoContainer {
    interface View extends BaseFragmentView {
        void onUserLoaded(UserResponse userResponse);
    }

    interface Presenter<V extends View> extends BasePresenter<V, UserInfoInteractor> {
        void onFetchUser(String username);
    }
}
