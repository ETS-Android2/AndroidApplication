package com.example.user.navigationdrawersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;

public class offerActicity extends AppCompatActivity {

    private static final String URL_DATA  ="https://test-deploiment.herokuapp.com/offers";


    Button btnCheckout,btnAdd;

    ArrayList<Offer> listOffer;
    RecyclerView myRecycle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        myRecycle =findViewById(R.id.myRecycle);

        listOffer = new ArrayList<>();
/*
        listOffer.add(new Offer(1,15,"Date1","Offer1"));
        listOffer.add(new Offer(2,10,"Date2","Offer2"));
        listOffer.add(new Offer(3,20,"Date3","Offer3"));
        listOffer.add(new Offer(4,21,"Date4","Offer4"));
        listOffer.add(new Offer(5,30,"Date5","Offer5"));
        listOffer.add(new Offer(6,70,"Date6","Offer6"));

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(offerActicity.this));
        myRecycle.setAdapter(new MyOfferAdapter(listOffer,offerActicity.this));
  */

        getListOffers();
        btnCheckout = findViewById(R.id.btnCheckout);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itAddOfferPage = new Intent(offerActicity.this,AddOffer.class);
                startActivity(itAddOfferPage);
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itDashboardPage = new Intent(offerActicity.this,MainActivity.class);
                startActivity(itDashboardPage);
            }
        });

    }

    private void getListOffers() {
        StringRequest stringRequest = new
                StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray array = null;
                        try {
                            array = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i =0;i<array.length();i++) {
                            JSONObject object = null;
                            try {
                                object = array.getJSONObject(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            int codeOffer = 0;
                            try {
                                codeOffer = object.getInt("idOffre");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            int nbPostOffer = 0;
                            try {
                                nbPostOffer = object.getInt("nbPost");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String TitreOffer = "";
                            try {
                                TitreOffer = object.getString("titre");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String DateOffer = "";
                            try {
                                DateOffer = object.getString("date");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            Offer o = new Offer(codeOffer,nbPostOffer,DateOffer,TitreOffer);
                            listOffer.add(o);
                        }

                        myRecycle.setHasFixedSize(true);
                        myRecycle.setLayoutManager(new LinearLayoutManager(offerActicity.this));
                        myRecycle.setAdapter(new MyOfferAdapter(listOffer,offerActicity.this));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(offerActicity.this,error.getMessage()+" error Loading Offers",Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }


}