package com.example.user.navigationdrawersample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class MyOfferAdapter extends RecyclerView.Adapter<MyOfferAdapter.MyViewHolder>{

    ArrayList<Offer> MyItemData;
    Context context;

    public MyOfferAdapter(ArrayList<Offer> myItemData, Context context) {
        MyItemData = myItemData;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.offer_item,parent,false);
        MyViewHolder viewholder = new MyViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyOfferAdapter.MyViewHolder holder, int position) {
        Offer myItemDataList = MyItemData.get(position);
        holder.code.setText(String.valueOf(myItemDataList.getId()));
        holder.titre.setText(myItemDataList.getTitre());
        holder.nb.setText(String.valueOf(myItemDataList.getNombrePost()));
        holder.date.setText(String.valueOf(myItemDataList.getDate()));
    }


    @Override
    public int getItemCount() {
        return MyItemData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView code,titre,date,nb;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            code = itemView.findViewById(R.id.codeOffer);
            titre = itemView.findViewById(R.id.titreOffer);
            date = itemView.findViewById(R.id.dateOffer);
            nb = itemView.findViewById(R.id.nombrePOffer);
        }
      }



}
