package com.loyer.dagger.data_manager;

import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface NetworkService {
    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );

    @GET("/users/{username}")
    Observable<UserResponse> getUser(
            @Path("username") String username
    );
}
