package com.loyer.dagger.ui.repositories_list_fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loyer.dagger.R;
import com.loyer.dagger.base.common.BaseFragment;
import com.loyer.dagger.data_manager.prefs.SharedPref;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.ui.repositories_list_fragment.adapter.RepositoriesListAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class RepositoriesListFragment extends BaseFragment implements RepositoriesListContainer.View {
    private static String USERNAME = "username";
    public static String TAG = "repositories_list_fragment";

    public static RepositoriesListFragment newInstance(String username) {
        Bundle args = new Bundle();
        args.putString(USERNAME, username);
        RepositoriesListFragment fragment = new RepositoriesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.rvRepositories)
    RecyclerView rvRepositories;

    @Inject
    RepositoriesListContainer.Presenter<RepositoriesListContainer.View> presenter;
    @Inject
    SharedPref pref;

    @Inject
    RepositoriesListAdapter adapter;

    private String username;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_repositories_list, container, false);
        bind(this, v);
        setupView();
        username = getArguments().getString(USERNAME, "");
        return v;
    }

    @Override
    public void onRepositoriesLoaded(List<RepositoryResponse> repositories) {
        adapter.updateRepositoriesList(repositories);
        Log.d("LOYER", "username: " + pref.getUsername());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.subscribeConnections();
        presenter.onFetchRepositories(username);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.unsubscribeConnections();
    }

    private void setupView() {
        rvRepositories.setAdapter(adapter);
        rvRepositories.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
