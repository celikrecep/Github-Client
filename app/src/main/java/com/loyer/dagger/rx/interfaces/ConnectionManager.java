package com.loyer.dagger.rx.interfaces;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface ConnectionManager {
    void disconnectAllConnections();

    void addConnection(ConnectionTracker connectionTracker);
}
