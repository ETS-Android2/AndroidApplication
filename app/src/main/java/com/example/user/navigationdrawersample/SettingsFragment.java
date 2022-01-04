package com.example.user.navigationdrawersample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends Fragment {
    EditText editText;
    CheckBox checkbox;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton selectedRadioButton;
    Spinner spinner;
    RatingBar ratingBar;
    Switch switch1; //NB : 'switch' est un mot clé du compilateur
    SeekBar seekBar;
    Button button;

    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_settings_layout, container, false);
        /* btnShare = rootView.findViewById(R.id.btnShare);*/
        //editText = (EditText) rootView.findViewById(R.id.editText1);
//        button=rootView.findViewById(R.id.btnmsg);
        ///Toast.makeText(context, s.toString(), Toast.LENGTH_SHORT).show();


        //button.setOnClickListener(new View.OnClickListener() {
          //  @Override
            ///public void onClick(View view) {
               // Toast.makeText(context, "nour !!!", Toast.LENGTH_SHORT).show();
           // }
        //});


return          rootView;

    }
}
