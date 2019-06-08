package com.loyer.dagger.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loyer.dagger.R;
import com.loyer.dagger.base.common.BaseFragment;
import com.loyer.dagger.ui.username_fragment.UserInfoFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class RootFragment extends BaseFragment {
    public static String TAG = "root_fragment";

    public static RootFragment newInstance() {

        return new RootFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.root_fragment, container, false);
        bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container_fragment, UserInfoFragment.newInstance())
                .commit();
    }
}
