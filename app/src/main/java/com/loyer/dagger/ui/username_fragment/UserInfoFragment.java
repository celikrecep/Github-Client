package com.loyer.dagger.ui.username_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.loyer.dagger.R;
import com.loyer.dagger.base.common.BaseFragment;
import com.loyer.dagger.data_manager.prefs.SharedPref;
import com.loyer.dagger.data_manager.response_modalz.UserResponse;
import com.loyer.dagger.ui.main.NavigationListener;
import com.loyer.dagger.ui.repositories_list_fragment.RepositoriesListFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class UserInfoFragment extends BaseFragment implements UserInfoCompact.View {
    public static String TAG = "user_info_fragment";

    public static UserInfoFragment newInstance() {
        return new UserInfoFragment();
    }

    @BindView(R.id.etUsername)
    EditText etUsername;

    @Inject
    UserInfoCompact.Presenter<UserInfoCompact.View> presenter;

    @Inject
    SharedPref pref;

    NavigationListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_info, container, false);
        bind(this, v);
        setupListener();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onUserLoaded(UserResponse userResponse) {
        if (listener != null)
            listener.onReplace(userResponse.login);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.onAttach(this);
        presenter.subscribeConnections();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }


    @Override
    public void onStop() {
        super.onStop();
        presenter.unsubscribeConnections();
    }

    private void setupListener() {
        if (getParentFragment() != null && getParentFragment() instanceof NavigationListener)
            listener = (NavigationListener) getParentFragment();
    }
    @OnClick(R.id.btnShowRepositories)
    public void onViewClicked() {
        presenter.onFetchUser(etUsername.getText().toString());
    }
}
