package com.example.rakesh.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakesh on 15-02-2017.
 */

public class BillboardAdapter extends RecyclerView.Adapter<BillboardAdapter.ViewHolder> {

    public List<Billboard> billboards;

    public BillboardAdapter() {
        this.billboards = new ArrayList<>();
        billboards.add(new Billboard(R.drawable.bb_lightweight));
        billboards.add(new Billboard(R.drawable.bb_cityscape));
        billboards.add(new Billboard(R.drawable.bb_dog));
        billboards.add(new Billboard(R.drawable.bb_leaves));
        billboards.add(new Billboard(R.drawable.bb_roots));
        billboards.add(new Billboard(R.drawable.bb_tajmahal));
        billboards.add(new Billboard(R.drawable.bb_vim));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BillboardAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.billboard_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Billboard billboard = billboards.get(position % billboards.size());
        holder.billboard.setImageResource(billboard.getDrawable());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView billboard;

        public ViewHolder(View itemView) {
            super(itemView);
            billboard = (ImageView) itemView.findViewById(R.id.card_billboard);
        }
    }
}
