package com.loyer.dagger.base.interfacezz;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface ConnectionControllable<V extends BaseView> {

    void onAttach(V view);

    void subscribeConnections();

    void unsubscribeConnections();

    void onDetach();
}
