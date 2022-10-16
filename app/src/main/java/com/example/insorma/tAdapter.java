package com.example.insorma;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class tAdapter extends RecyclerView.Adapter<tAdapter.ViewHolder> {

    ArrayList<Transactions> usertransactionDB;

    public tAdapter(ArrayList<Transactions> transactions) {
        usertransactionDB = transactions;
    }

    @NonNull
    @Override
    public tAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transactionlayout , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Integer calctemp = 0;
        String pdtName = "";
        for (int i = 0 ; i < Home.productDB.size() ; i++){
            if(Home.productDB.get(i).getProductName().equals(usertransactionDB.get(position).getPID())){
                calctemp = Home.productDB.get(i).getProductPrice();
                pdtName = Home.productDB.get(i).getProductName();
            }
        }
        Integer calc = usertransactionDB.get(position).getTransQty() * calctemp;
        String ttIDtxt = "TxId: " + usertransactionDB.get(position).getTransId().toString();
        String ttQtytxt = "Qty : " + usertransactionDB.get(position).getTransQty().toString();
        String ttPricetxt = "$ " + calc.toString();

        holder.ttID.setText(ttIDtxt);
        holder.ttName.setText(pdtName);
        holder.ttQty.setText(ttQtytxt);
        holder.ttDate.setText(usertransactionDB.get(position).getTransDate());
        holder.ttPrice.setText(ttPricetxt);
    }

    @Override
    public int getItemCount() {
        return usertransactionDB.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ttID;
        public TextView ttName;
        public TextView ttPrice;
        public TextView ttQty;
        public TextView ttDate;

        public ViewHolder(View itemView) {
            super(itemView);

            ttID = itemView.findViewById(R.id.tID);
            ttName = itemView.findViewById(R.id.tName);
            ttPrice = itemView.findViewById(R.id.tPrice);
            ttQty = itemView.findViewById(R.id.tQty);
            ttDate = itemView.findViewById(R.id.tDate);
        }
    }
}
