package com.example.user.navigationdrawersample;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


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
        final Offer myItemDataList = MyItemData.get(position);
        holder.code.setText(String.valueOf(myItemDataList.getId()));
        holder.titre.setText(myItemDataList.getTitre());
        holder.nb.setText(String.valueOf(myItemDataList.getNombrePost()));
        holder.date.setText(String.valueOf(myItemDataList.getDate()));
/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,myItemDataList.getTitre(),Toast.LENGTH_LONG).show();
                getOffer(myItemDataList);
            }
        });
*/
    }

/*

    private void getOffer(Offer offer) {
        Button close;
        TextView dateOf, nbPost, titletxt;
        final Dialog dialog;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.info_Offer);

        titletxt = dialog.findViewById(R.id.title);
        dateOf = dialog.findViewById(R.id.datetxt);
        nbPost = dialog.findViewById(R.id.nbPosttxt);
        close = dialog.findViewById(R.id.close);

        titletxt.setText("Information Offer ");
        dateOf.setText("date: " + offer.getDate().toString());
        nbPost.setText("nombre Post : " + offer.getNombrePost() + "TND");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


*/
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
