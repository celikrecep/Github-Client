package com.loyer.dagger.rx.interfaces;

import io.reactivex.Scheduler;

/**
 * Created by celikrecep on 7.06.2019.
 */
public interface SchedulerProvider {
    Scheduler schedulerUI();
    Scheduler schedulerIO();
}
