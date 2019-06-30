package com.tritechteal.sport_hub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DisplayTeam extends AppCompatActivity {
    public static ArrayList<String> TeamName = new ArrayList<>();
    public static ArrayList<String> TeamSport = new ArrayList<>();
    public static ArrayList<String> CityName = new ArrayList<>();
    public static ArrayList<String> PhoneNo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_team);


        //Get Code
        String url = "http://192.168.10.10/SportHub/api/RegisterTeam/";
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("apicallres", response.toString());


                try {



                    for (int i = 0; i < response.length(); i++) {
                        JSONObject c = response.getJSONObject(i);
                        TeamName.add(c.getString("TeamName").toString().trim());
                        TeamSport.add(c.getString("TeamSport").toString().trim());
                        CityName.add(c.getString("CityName").toString().trim());
                        PhoneNo.add(c.getString("PhoneNo").toString().trim());
                        Logic.TeamId.add(c.getString("TeamId").toString().trim());

                        if(i==(response.length()-1))
                        {
                            RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.act_recyclerviewTeamDisplay);




                            DataAdapterTeam mDataAdapter = new DataAdapterTeam(DisplayTeam.this, TeamName , TeamSport, CityName,PhoneNo);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mRecyclerView.setAdapter(mDataAdapter);
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(DisplayTeam.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, "");



        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.act_recyclerviewTeamDisplay);



        DataAdapterTeam mDataAdapter = new DataAdapterTeam(DisplayTeam.this, TeamName , TeamSport, CityName,PhoneNo);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mDataAdapter);




    }



}




