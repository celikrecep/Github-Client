package com.loyer.dagger.base.common;

import com.loyer.dagger.base.interfacezz.BaseInteractor;
import com.loyer.dagger.base.interfacezz.BaseModel;
import com.loyer.dagger.rx.interfaces.ConnectionManager;
import com.loyer.dagger.rx.interfaces.ConnectionTracker;

/**
 * Created by celikrecep on 7.06.2019.
 */
public class BaseInteractorImpl<M extends BaseModel> implements BaseInteractor<M> {

    private M model;
    private ConnectionManager connectionManager;


    public BaseInteractorImpl(M model, ConnectionManager connectionManager) {
        this.model = model;
        this.connectionManager = connectionManager;
    }

    @Override
    public void removeAllConnections() {
        connectionManager.disconnectAllConnections();
    }

    @Override
    public M getModel() {
        return model;
    }

    @Override
    public void addConnection(ConnectionTracker connectionTracker) {
        connectionManager.addConnection(connectionTracker);
    }
}
