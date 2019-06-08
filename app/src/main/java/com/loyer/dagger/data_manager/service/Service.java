package com.loyer.dagger.data_manager.service;

import com.loyer.dagger.data_manager.RequestListener;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;

import java.util.List;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface Service {
    void onFetchRepositories(RequestListener<List<RepositoryResponse>> requestListener,String username);
    void onFetchUser(RequestListener<UserResponse> requestListener, String username);
}
