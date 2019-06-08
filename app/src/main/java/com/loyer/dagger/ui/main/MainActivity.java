package com.loyer.dagger.ui.main;

import android.os.Bundle;

import com.loyer.dagger.R;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.ui.username_fragment.UserInfoFragment;

import java.util.List;

import javax.inject.Inject;

import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainActivityContainer.View {

    @Inject
    MainActivityContainer.Presenter<MainActivityContainer.View> presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupFragment();
    }

    @Override
    public void onRepositoriesLoaded(List<RepositoryResponse> repositories) {
    }

    private void setupFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, RootFragment.newInstance(), RootFragment.TAG)
                .commit();
    }

    @Override
    public void onBackPressed() {
        RootFragment fragment = (RootFragment) getSupportFragmentManager().findFragmentByTag(RootFragment.TAG);
        if (fragment.getFragmentManager().getBackStackEntryCount() != 0)
            fragment.getFragmentManager().popBackStackImmediate();
        else
             super.onBackPressed();
    }
}
