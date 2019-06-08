package com.loyer.dagger.rx.clazz;

import android.util.Log;

import com.loyer.dagger.rx.interfaces.ObservableData;
import com.loyer.dagger.rx.interfaces.ObservableDataListener;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class ObservableDataImpl<T> implements ObservableData<T> {

    private BehaviorSubject<T> rxSubject;

    public ObservableDataImpl() {
        rxSubject = BehaviorSubject.create();
    }

    public ObservableDataImpl(T defaultValue) {
        rxSubject = BehaviorSubject.createDefault(defaultValue);
    }

    @Override
    public void connect(ObservableDataListener<T> dataListener) {
        rxSubject.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(T t) {
                        dataListener.onDataChanged(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        dataListener.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        dataListener.onComplete();
                    }
                });
    }

    @Override
    public T getCurrentValue() {
        return rxSubject.getValue();
    }

    @Override
    public synchronized void postValue(T value) {
        rxSubject.onNext(value);
    }

    @Override
    public void close() {
        rxSubject.onComplete();
    }
}
