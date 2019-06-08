package com.loyer.dagger.rx.interfaces;

import java.util.List;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface ObservableList<T> {

    void connect(ObservableListListener<T> listListener);

    void addItem(T item);

    void removeItem(int position);

    void updateItem(int position, T newItem);

    void refreshData(List<T> list);

    T getItemAt(int position);

    boolean isLoaded();

    void close();

}
