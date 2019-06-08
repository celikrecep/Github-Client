package com.loyer.dagger.base.interfacezz;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface BasePresenter<V extends BaseView, I extends BaseInteractor>
extends ConnectionControllable<V> {
    I getInteractor();

    V getView();

    void clearInteractorConnections();
}
