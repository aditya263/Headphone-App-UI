package com.example.headphonesapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headphonesapp.Interface.OnRecyclerItemClickListener;
import com.example.headphonesapp.Model.MainModel;
import com.example.headphonesapp.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private final List<MainModel> mainModelList;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public MainAdapter(List<MainModel> mainModelList) {
        this.mainModelList = mainModelList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.headphone_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.imageView.setImageResource(mainModelList.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return mainModelList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public MainViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageItems);

            itemView.setOnClickListener(view -> {
                if (onRecyclerItemClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        onRecyclerItemClickListener.onClick(position);
                    }
                }
            });
        }
    }

}
