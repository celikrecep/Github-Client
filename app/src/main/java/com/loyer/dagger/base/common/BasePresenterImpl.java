package com.loyer.dagger.base.common;

import com.loyer.dagger.base.interfacezz.BaseInteractor;
import com.loyer.dagger.base.interfacezz.BasePresenter;
import com.loyer.dagger.base.interfacezz.BaseView;
import com.loyer.dagger.rx.interfaces.ConnectionManager;

import java.lang.ref.WeakReference;

/**
 * Created by celikrecep on 7.06.2019.
 */
public class BasePresenterImpl<V extends BaseView, I extends BaseInteractor>
                implements BasePresenter<V, I> {

    private ConnectionManager connectionManager;
    private WeakReference<V> view;
    private I interactor;

    public BasePresenterImpl(ConnectionManager connectionManager, I interactor) {
        this.connectionManager = connectionManager;
        this.interactor = interactor;
    }

    @Override
    public I getInteractor() {
        return interactor;
    }

    @Override
    public V getView() {
        return view.get();
    }

    @Override
    public void clearInteractorConnections() {
            interactor.removeAllConnections();
            interactor = null;
    }

    @Override
    public void onAttach(V view) {
        this.view = new WeakReference<V>(view);
    }

    @Override
    public void subscribeConnections() {

    }

    @Override
    public void unsubscribeConnections() {
        connectionManager.disconnectAllConnections();
    }

    @Override
    public void onDetach() {
        clearInteractorConnections();
        if (view != null)
            view.clear();
        view = null;
    }
}
