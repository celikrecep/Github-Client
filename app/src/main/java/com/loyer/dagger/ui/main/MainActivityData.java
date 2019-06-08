package com.loyer.dagger.ui.main;

import com.loyer.dagger.base.interfacezz.BaseDataModel;
import com.loyer.dagger.base.interfacezz.BaseModel;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.di.qualifiers.ActivityScope;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by celikrecep on 7.06.2019.
 */
@ActivityScope
public class MainActivityData extends BaseDataModel {
    @Inject
    public MainActivityData(){};

    public List<RepositoryResponse> repositories = new ArrayList<>();
}
