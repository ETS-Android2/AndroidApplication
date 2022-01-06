package com.example.user.navigationdrawersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddOffer extends AppCompatActivity {

    Button btnCheckout,btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);

        btnCheckout = findViewById(R.id.buttonCheckout);
        btnAdd = findViewById(R.id.buttonAdd);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itDashboardPage = new Intent(AddOffer.this,offerActicity.class);
                startActivity(itDashboardPage);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddOffer.this,"Add successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}