package com.example.insorma;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pAdapter extends RecyclerView.Adapter<pAdapter.ViewHolder> {

    ArrayList<Product> productDB;
    private OnNoteListener pOnNoteListener;

    public pAdapter(ArrayList<Product> products , OnNoteListener onNoteListener) {
        productDB = products;
        this.pOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public pAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playout, parent, false);
        return new ViewHolder(view , pOnNoteListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ppName.setText(productDB.get(position).getProductName());
        holder.ppPrices.setText(productDB.get(position).getProductPrice().toString());
        holder.ppImages.setImageResource(productDB.get(position).getProductImage());
    }

    @Override
    public int getItemCount() {
        return productDB.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView ppName;
        public TextView ppPrices;
        public ImageView ppImages;
        OnNoteListener onNoteListener;

        public ViewHolder(View itemView , OnNoteListener onNoteListener) {
            super(itemView);

            ppName = itemView.findViewById(R.id.pName);
            ppPrices = itemView.findViewById(R.id.pPrice);
            ppImages = itemView.findViewById(R.id.pFurniture);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
