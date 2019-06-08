package com.loyer.dagger.data_manager.service;

import com.loyer.dagger.data_manager.NetworkService;
import com.loyer.dagger.data_manager.RequestListener;
import com.loyer.dagger.data_manager.ServiceUtils;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by celikrecep on 7.06.2019.
 */
@Singleton
public class ServiceImpl implements Service {

    NetworkService service;

    @Inject
    public ServiceImpl(NetworkService service) {
        this.service = service;
    }

    @Override
    public void onFetchRepositories(RequestListener<List<RepositoryResponse>> requestListener, String username) {
        ServiceUtils.connectObservable(service.getUsersRepositories(username),
                requestListener
        );
    }

    @Override
    public void onFetchUser(RequestListener<UserResponse> requestListener, String username) {
        ServiceUtils.connectObservable(service.getUser(username),
                requestListener);
    }
}
