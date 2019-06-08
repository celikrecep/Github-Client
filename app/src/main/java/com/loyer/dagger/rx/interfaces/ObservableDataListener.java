package com.loyer.dagger.rx.interfaces;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface ObservableDataListener<T> {
    void onDataChanged(T data);

    void onComplete();

    void onError(Throwable e);
}
