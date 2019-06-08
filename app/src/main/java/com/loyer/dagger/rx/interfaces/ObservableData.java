package com.loyer.dagger.rx.interfaces;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface ObservableData<T> {
    void connect(ObservableDataListener<T> dataListener);

    T getCurrentValue();

    void postValue(T value);

    void close();
}
