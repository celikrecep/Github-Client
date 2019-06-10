package com.loyer.dagger.base.common;

import android.content.Context;
import android.util.Log;

import com.loyer.dagger.base.interfacezz.ViewStackOwner;
import com.loyer.dagger.ui.main.NavigationManager;

import androidx.fragment.app.Fragment;

/**
 * Created by celikrecep on 10.06.2019.
 */
public abstract class StackOwnerFragment extends BaseFragment implements ViewStackOwner {

    private static final String INITIAL_FRAG_TAG = "INITIAL_FRAG";

    public abstract Fragment getInitialFragment();

    public abstract NavigationManager getNavigationManager();

    public abstract int getHostLayoutId();


    @Override
    public boolean consumePopStackEvent() {
        if(getChildFragmentManager().getBackStackEntryCount() == 1){
            return false;
        }
        return getChildFragmentManager().popBackStackImmediate();
    }


    @Override
    public void resetToInitialState() {
        getChildFragmentManager().popBackStackImmediate(INITIAL_FRAG_TAG,0);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getNavigationManager().registerStackOwner(getClass().getName(),this);
        Log.d("Class Name",getClass().getName());
    }


    @Override
    public void onDetach() {
        super.onDetach();
        getNavigationManager().unregisterStackOwner(getClass().getName());
    }

    public void showInitialFragment(){
        FragmentTransactionContainer container = new FragmentTransactionContainer.Builder()
                .setBackState(true,INITIAL_FRAG_TAG)
                .setHasAnimation(false)
                .setLayoutId(getHostLayoutId())
                .setTransactionType(FragmentTransactionContainer.TransactionType.ADD)
                .build();

        showFragment(getChildFragmentManager(),container,getInitialFragment());
    }
}
