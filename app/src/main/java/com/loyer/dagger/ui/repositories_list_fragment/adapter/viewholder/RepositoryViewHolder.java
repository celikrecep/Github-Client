package com.loyer.dagger.ui.repositories_list_fragment.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loyer.dagger.R;
import com.loyer.dagger.data_manager.modal.Repository;
import com.loyer.dagger.data_manager.response_modalz.RepositoryResponse;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class RepositoryViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.tvName)
    TextView tvName;

    public RepositoryViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(RepositoryResponse repository) {
        tvName.setText(repository.name);
    }

}
