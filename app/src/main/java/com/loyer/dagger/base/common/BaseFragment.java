package com.loyer.dagger.base.common;

import android.view.View;

import com.loyer.dagger.base.interfacezz.BaseView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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

    public void showFragment(
            FragmentManager manager,
            FragmentTransactionContainer container,
            Fragment fragment
    ) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (container.getTransactionType()) {
            case ADD:
                transaction.add(container.getLayoutId(), fragment);
            case REPLACE:
                transaction.replace(container.getLayoutId(), fragment);
        }
        if(container.isBackStack()){
            transaction.addToBackStack(container.getBackStackTag());
        }

        if(container.isHasAnimation()){
          /*  transaction.setCustomAnimations(
                    R.anim.enter_from_left,
                    R.anim.exit_to_right,
                    R.anim.enter_from_right,
                    R.anim.exit_to_left
            );*/
        }

        transaction.commit();
        manager.executePendingTransactions();
    }
}
