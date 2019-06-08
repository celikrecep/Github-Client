package com.loyer.dagger.rx.clazz;

import com.loyer.dagger.rx.interfaces.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by celikrecep on 7.06.2019.
 */
public class SchedulerProviderImpl implements SchedulerProvider {

    @Inject
    public SchedulerProviderImpl(){
    }

    @Override
    public Scheduler schedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler schedulerIO() {
        return Schedulers.io();
    }

}
