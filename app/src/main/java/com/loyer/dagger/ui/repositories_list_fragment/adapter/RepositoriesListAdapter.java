package com.loyer.dagger.ui.repositories_list_fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loyer.dagger.R;
import com.loyer.dagger.data_manager.modal.Repository;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;
import com.loyer.dagger.di.qualifiers.ActivityContext;
import com.loyer.dagger.ui.repositories_list_fragment.adapter.viewholder.RepositoryViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class RepositoriesListAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {

    private Context context;
    private List<RepositoryResponse> repositories;

    @Inject
    public RepositoriesListAdapter(@ActivityContext Context context) {
        this.context = context;
        repositories = new ArrayList<>();
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_normal, parent, false);
        return new RepositoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        holder.bind(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public void updateRepositoriesList(List<RepositoryResponse> repositories) {
        this.repositories.clear();
        this.repositories.addAll(repositories);
        notifyDataSetChanged();
    }
}
