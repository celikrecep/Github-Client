package com.loyer.dagger.data_manager;

import android.util.Log;

import com.loyer.dagger.rx.clazz.ConnectionTrackerImpl;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by celikrecep on 7.06.2019.
 */
public final class ServiceUtils {
    public static <T> void connectObservable(
            Observable<T> observable,
            RequestListener<T> requestListener
    ) {
        observable.subscribe(new Observer<T>() {
            @Override
            public void onSubscribe(Disposable d) {
                requestListener.onRequestSend(new ConnectionTrackerImpl(d));
            }
            @Override
            public void onNext(T t) {
                requestListener.onResponseCome(t);
            }

            @Override
            public void onError(Throwable e) {
                requestListener.onRequestError(e);
            }

            @Override
            public void onComplete() {
                requestListener.onRequestCompleted();
            }
        });
    }
}
