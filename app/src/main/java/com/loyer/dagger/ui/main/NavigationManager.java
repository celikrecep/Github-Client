package com.loyer.dagger.ui.main;

import com.loyer.dagger.base.interfacezz.ViewStackOwner;
import com.loyer.dagger.di.qualifiers.ActivityScope;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by celikrecep on 10.06.2019.
 */
@ActivityScope
public class NavigationManager {
    private HashMap<String, ViewStackOwner> mStackOwnerMap;
    private ViewStackOwner mStackOwner;

    @Inject
    public NavigationManager() {
        mStackOwnerMap = new HashMap<>();
    }

    public void registerStackOwner(String className, ViewStackOwner stackOwner){
        mStackOwnerMap.put(className,stackOwner);
    }

    public void unregisterStackOwner(String className){
        if(mStackOwnerMap.get(className) == mStackOwner){
            mStackOwner = null;
        }
        mStackOwnerMap.remove(className);
    }

    public boolean consumeBackPress(){
        if(mStackOwner != null){
            return mStackOwner.consumePopStackEvent();
        }
        return false;
    }

    public void setConsumerName(String className){
        mStackOwner = mStackOwnerMap.get(className);
    }


    public void consumeReselect(){
        if(mStackOwner != null){
            mStackOwner.resetToInitialState();
        }
    }
}
