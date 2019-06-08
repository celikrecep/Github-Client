package com.loyer.dagger.rx.interfaces;

import java.util.List;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface ObservableListListener<T> {

    void onDataInitial(List<T> list);

    void onDataAdded(List<T> list);

    void onDataRemoved(List<T> list, int position);

    void onDataUpdated(List<T> list, int posiiton);

    void onComplete();

    void onError(Throwable e);

}
