package com.loyer.dagger.rx;

/**
 * Created by celikrecep on 8.06.2019.
 */
public interface DiffObservable {
    public static final int ADD = 1;
    public static final int REMOVE = 2;
    public static final int UPDATE = 3;
    public static final int DATA_REFRESHED = 4;
}
