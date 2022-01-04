package com.example.user.navigationdrawersample;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddOfferActivity extends AppCompatActivity {

    private static final String URL_DATA  ="https://test-deploiment.herokuapp.com/offers";
    EditText id,titre,nb,date;
    Button btnCheckout,btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);

        id = findViewById(R.id.idpost);
        titre = findViewById(R.id.postname);
        nb = findViewById(R.id.nbpostpostuler);
        date = findViewById(R.id.datepost);

        btnCheckout = findViewById(R.id.buttonCheckout);
        btnAdd = findViewById(R.id.buttonAdd);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itDashboardPage = new Intent(AddOfferActivity.this,offerActicity.class);
                startActivity(itDashboardPage);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //Ajouter id et nb Post
 /*               String StrNamePost = titre.getText().toString();
                String StrDate = date.getText().toString();
               final Offer offer = new Offer(1,15,null,"helooooooo");
                submit(offer);
*/
                /*Intent itDashboardPage = new Intent(AddOfferActivity.this,offerActicity.class);
                startActivity(itDashboardPage);*/
            }
        });
    }

/*

    private void addCompe(View v){
        StringRequest stringRequest = new
                StringRequest(Request.Method.POST,
                        URL_DATA,
                        response -> Toast.makeText(this,"success",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(AddOfferActivity.this,"Failed",Toast.LENGTH_LONG).show()){
                    @Override
                    protected Map<String,String> getParams()throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        long code = 1;
                        double solde = 1.200;
                        Date date = new Date(2005);

                        params.put("code",String.valueOf(code));
                        // params.put("solde",solde.getText().toString());
                        params.put("solde",String.valueOf(solde));
                        params.put("date",date.toString());
                        return params;
                    }
                };

        Volley.newRequestQueue(MainActivity.this).add(stringRequest);

    }
*/

   public void addcompte(View v) {
        TextView title;
        Button close;
        final EditText solde,date;
        Button submit;

        id = findViewById(R.id.idpost);
        titre = findViewById(R.id.postname);
        nb = findViewById(R.id.nbpostpostuler);
        date = findViewById(R.id.datepost);
        btnAdd = findViewById(R.id.buttonAdd);
        System.out.println(date);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Offer offer = new Offer(1,15,null,"helooooooo");
                submit(offer);
            }
        });
    }


    //Methode Post
    private void submit(final Offer o) {
        JSONObject postData = new JSONObject();
        try {
            postData.put("idOffre", o.getId());
            //   postData.put("desecration",date);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            postData.put("titre", o.getTitre());
            //   postData.put("desecration",date);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            postData.put("nbPost", o.getNombrePost());
            //   postData.put("desecration",date);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*try {
            postData.put("date", o.getDate());
            //   postData.put("desecration",date);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        JsonRequest r = new JsonObjectRequest(Request.Method.POST, URL_DATA, postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                      /*  refresh.post(new Runnable() {
                            @Override
                            public void run() {
                                Comptes.clear();
                                getdata();
                            }
                        });*/
                        Toast.makeText(getApplicationContext(), "Offer added", Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error adding offer", Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String,String> getParams()throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                long code = 1;
                double solde = 1.200;
                Date date = new Date(2005);

                params.put("idOffre",String.valueOf(code));
                // params.put("solde",solde.getText().toString());
                params.put("titre",String.valueOf(solde));
                params.put("nbPost",    date.toString());
                return params;
            }

        };
        Volley.newRequestQueue(this).add(r);
    }

}