package com.loyer.dagger.rx.clazz;

import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.rx.interfaces.ConnectionTracker;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class ConnectionManagerImpl implements ConnectionManager {

    private CompositeDisposable compositeDisposable;

    public ConnectionManagerImpl() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void disconnectAllConnections() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    @Override
    public void addConnection(ConnectionTracker connectionTracker) {
        compositeDisposable.add(((ConnectionTrackerImpl) connectionTracker).getDisposable());
    }
}
