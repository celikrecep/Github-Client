package com.loyer.dagger.ui.username_fragment;

import com.loyer.dagger.base.interfacezz.BaseDataModel;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;
import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.rx.interfaces.ObservableData;
import com.loyer.dagger.rx.clazz.ObservableDataImpl;

import javax.inject.Inject;

/**
 * Created by celikrecep on 8.06.2019.
 */
@FragmentScope
public class UserInfoData extends BaseDataModel {
    @Inject
    public UserInfoData() {
    }

    public ObservableData<UserResponse> response = new ObservableDataImpl<>();
}
