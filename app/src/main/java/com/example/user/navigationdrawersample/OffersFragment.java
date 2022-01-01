package com.example.user.navigationdrawersample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OffersFragment extends Fragment {

    private Button btnAdd;

    private OnButtonClickedListenerOffer mcallBackOffer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_offers_layout, container, false);


        btnAdd = rootView.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcallBackOffer.onButtonClickedOffer(v);
            }
        });
        return rootView;
    }

    //méthode suivante permettant d’attribuer le contexte de l’activité parente
    //(mainActivity) au listner
    private void createCallBackToParentActivity() {
        try {
            mcallBackOffer = (OnButtonClickedListenerOffer) getActivity();
        } catch (Exception e) {
            e.toString();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createCallBackToParentActivity();
    }


    public interface OnButtonClickedListenerOffer {
        public void onButtonClickedOffer(View view);
    }
}