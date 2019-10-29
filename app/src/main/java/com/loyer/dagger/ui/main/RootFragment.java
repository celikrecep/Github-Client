package com.loyer.dagger.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loyer.dagger.R;
import com.loyer.dagger.base.common.BaseFragment;
import com.loyer.dagger.base.common.FragmentTransactionContainer;
import com.loyer.dagger.base.common.StackOwnerFragment;
import com.loyer.dagger.ui.repositories_list_fragment.RepositoriesListFragment;
import com.loyer.dagger.ui.username_fragment.UserInfoFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class RootFragment extends StackOwnerFragment implements NavigationListener {
    public static String TAG = "root_fragment";

    @Inject
    NavigationManager manager;

    public static RootFragment newInstance() {

        return new RootFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.root_fragment, container, false);
       showInitialFragment();
       manager.setConsumerName(getClass().getName());
        return v;
    }

    @Override
    public Fragment getInitialFragment() {
        return UserInfoFragment.newInstance();
    }

    @Override
    public NavigationManager getNavigationManager() {
        return manager;
    }

    @Override
    public int getHostLayoutId() {
        return R.id.fl_container_fragment;
    }

    @Override
    public void onReplace(String username) {
        showFragment(getChildFragmentManager(),
                new FragmentTransactionContainer.Builder()
                .setLayoutId(getHostLayoutId())
        .setTransactionType(FragmentTransactionContainer.TransactionType.REPLACE)
        .setHasAnimation(false)
        .setBackState(true, null)
        .build(), RepositoriesListFragment.newInstance(username));
    }
}
