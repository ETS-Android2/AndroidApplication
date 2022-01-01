package com.example.user.navigationdrawersample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NotebooksFragment extends Fragment {

    private Button btnShare;
    private EditText name, message;

    private OnButtonClickedListener mcallBack;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notebooks_layout, container, false);


        btnShare = rootView.findViewById(R.id.btnShare);

        name = rootView.findViewById(R.id.name_field);
        message = rootView.findViewById(R.id.message_field);

        final String DetailsSahred = "name : " + name + " Message : " + message;

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcallBack.onButtonClicked(v);
            }
        });
        return rootView;
    }

    //méthode suivante permettant d’attribuer le contexte de l’activité parente
    //(mainActivity) au listner
    private void createCallBackToParentActivity() {
        try {
            mcallBack = (OnButtonClickedListener) getActivity();
        } catch (Exception e) {
            e.toString();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createCallBackToParentActivity();
    }


    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }

}