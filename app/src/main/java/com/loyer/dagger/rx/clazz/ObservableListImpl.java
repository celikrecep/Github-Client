package com.loyer.dagger.rx.clazz;

import com.loyer.dagger.rx.DiffObservable;
import com.loyer.dagger.rx.DifferentObservable;
import com.loyer.dagger.rx.interfaces.ObservableList;
import com.loyer.dagger.rx.interfaces.ObservableListListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class ObservableListImpl<T> implements ObservableList<T>, DiffObservable {

    private Subject<DifferentObservable> observable;
    private List<T> list;
    private boolean isLoaded;

    public ObservableListImpl() {
        observable = PublishSubject.create();
        list = new ArrayList<>();
        isLoaded = false;
    }

    @Override
    public void connect(ObservableListListener<T> listListener) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DifferentObservable>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DifferentObservable differentObservable) {
                        switch (differentObservable.getDiffType()) {
                            case ADD:
                                listListener.onDataAdded(list);
                                break;
                            case REMOVE:
                                listListener.onDataRemoved(list, differentObservable.getPosition());
                                break;
                            case UPDATE:
                                listListener.onDataUpdated(list, differentObservable.getPosition());
                                break;
                            case DATA_REFRESHED:
                                listListener.onDataInitial(list);
                                break;
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public synchronized void addItem(T item) {
        list.add(item);
        observable.onNext(new DifferentObservable(ADD, list.size() - 1));
    }

    @Override
    public synchronized void removeItem(int position) {
        list.remove(position);
        observable.onNext(new DifferentObservable(REMOVE, position));
    }

    @Override
    public synchronized void updateItem(int position, T newItem) {
        list.add(position, newItem);
        observable.onNext(new DifferentObservable(UPDATE, position));

    }

    @Override
    public synchronized void refreshData(List<T> list) {
        this.list.clear();
        this.list.addAll(list);
        setLoaded(true);
        observable.onNext(new DifferentObservable(DATA_REFRESHED));
    }

    @Override
    public synchronized T getItemAt(int position) {
        return list.get(position);
    }

    @Override
    public synchronized boolean isLoaded() {
        return isLoaded;
    }

    private synchronized void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    @Override
    public synchronized void close() {
        observable.onComplete();
    }
}
