package com.loyer.dagger.base.common;

import android.view.View;

import com.loyer.dagger.base.interfacezz.BaseView;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by celikrecep on 7.06.2019.
 */
public class BaseFragment extends DaggerFragment implements BaseView {
    private Unbinder unbinder;

    public void bind(Fragment targetFragment, View view) {
        unbinder = ButterKnife.bind(targetFragment, view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }
}
