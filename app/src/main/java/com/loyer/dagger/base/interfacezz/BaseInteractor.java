package com.loyer.dagger.base.interfacezz;

import com.loyer.dagger.rx.interfaces.ConnectionTracker;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface BaseInteractor <M extends BaseModel> {
    void removeAllConnections();

    M getModel();

    void addConnection(ConnectionTracker connectionTracker);

}
