package com.tritechteal.sport_hub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.jar.Attributes;

public class CurrentPreviousTournament extends AppCompatActivity {
    public static ArrayList<String> TournamentName = new ArrayList<>();
    public static ArrayList<String> Venue = new ArrayList<>();
    public static ArrayList<String> Sport = new ArrayList<>();
    public static ArrayList<String> StartDate = new ArrayList<>();
    public static ArrayList<String> EndDate = new ArrayList<>();
    public static ArrayList<String> Description = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_previous_tournament);




        //DataAdapter mDataAdapter = new DataAdapter(CurrentPreviousTournament.this, TournamentName , TournamentDetial);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        //mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.setAdapter(mDataAdapter);

        //Get Code
        String url = "http://192.168.10.10/SportHub/api/AddTournament/";
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("apicallres", response.toString());


                try {




                    for (int i = 0; i < response.length(); i++)
                    {
                        JSONObject c = response.getJSONObject(i);

                        TournamentName.add(c.getString("TournamentName").toString().trim());
                        Venue.add(c.getString("Venue").toString().trim());
                        Sport.add(c.getString("Sport").toString().trim());
                        StartDate.add(c.getString("StartDate").toString().trim());
                        EndDate.add(c.getString("EndDate").toString().trim());
                        Description.add(c.getString("Description").toString().trim());

                    }






                        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.act_recyclerview3);



                    DataAdapter mDataAdapter = new DataAdapter(CurrentPreviousTournament.this, TournamentName , Venue,Sport,StartDate,EndDate,Description);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mDataAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(CurrentPreviousTournament.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, "");









    }
}
