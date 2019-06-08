package com.loyer.dagger.rx.clazz;

import com.loyer.dagger.rx.interfaces.ConnectionTracker;

import io.reactivex.disposables.Disposable;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class ConnectionTrackerImpl implements ConnectionTracker {
    private Disposable disposable;

    public ConnectionTrackerImpl(Disposable d) {
        disposable = d;
    }

    @Override
    public void disconnect() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public Disposable getDisposable() {
        return disposable;
    }
}
