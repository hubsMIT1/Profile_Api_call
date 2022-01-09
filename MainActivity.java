package com.example.profile_api_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//import android.util.Log;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
//import com.squareup.picasso.Picasso;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import  org.json.JSONException;
import com.bumptech.glide.Glide;
//import java.net.http.HttpRequest;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

       String [] arr = {"shiva","ranjan"};

       List<Profiles> profilesList;
       private static  String   url = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/all.json";
       CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        profilesList = new ArrayList<>();
    heroesProfile();


    }



        private  void heroesProfile() {


            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){


                @Override
                public void onResponse(JSONArray response) {

                    for(int i = 0; i<= 1; i++){


                    try {

                        JSONObject responseObj = response.getJSONObject(i);

                        Profiles profiles = new Profiles();

                        profiles.setId(responseObj.getString("id").toString());
//                        profiles.setName(responseObj.getString("name").toString());
//                        JSONObject imgurl = responseObj.getJSONObject("images");
//                        profiles.setImges(imgurl.getString("md"));
//                        Log.d()


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    customAdapter = new CustomAdapter( getApplicationContext(),profilesList);
                    recyclerView.setAdapter(customAdapter);
                }


            }, new Response.ErrorListener()

            {

                @Override
                public void onErrorResponse (VolleyError error){
                    Profiles profiles = new Profiles();
                    profiles.setId("nothing is here");
//                txtV.setText("error show");
//                 Log.d
                }

            });
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);

//        recyclerView.setAdapter(names);
        }

        }



//}