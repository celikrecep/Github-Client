package com.loyer.dagger.data_manager;

import com.loyer.dagger.rx.interfaces.ConnectionTracker;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface RequestListener<T> {

    void onRequestSend(ConnectionTracker tracker);

    void onResponseCome(T response);

    void onRequestError(Throwable error);

    void onRequestCompleted();
}
