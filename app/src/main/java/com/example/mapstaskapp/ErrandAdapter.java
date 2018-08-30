package com.example.mapstaskapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ErrandAdapter extends RecyclerView.Adapter<ErrandAdapter.MyViewHolder> {
    public List<Errand> errands;

    public ErrandAdapter() {
        errands = new ArrayList<>();

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = new LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.errand_item, parent, false);

        RecyclerView.ViewHolder vh = new MyViewHolder(view);

        return vh;
    }

    @Override
    public void onBindView(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            desc = itemView.findViewById(R.id.desc);
        }

        public void bind(Errand errand) {
            desc.setText(errand.description);
        }
    }
}
