package com.loyer.dagger.ui.repositories_list_fragment;

import com.loyer.dagger.base.interfacezz.BaseDataModel;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.di.qualifiers.FragmentScope;
import com.loyer.dagger.rx.clazz.ObservableListImpl;
import com.loyer.dagger.rx.interfaces.ObservableList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by celikrecep on 8.06.2019.
 */
@FragmentScope
public class RepositoriesListData extends BaseDataModel {
    @Inject
    public RepositoriesListData() {
    }
    public ObservableList<RepositoryResponse> repositories = new ObservableListImpl<>();
}
