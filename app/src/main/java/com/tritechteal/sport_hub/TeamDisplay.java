package com.tritechteal.sport_hub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
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

public class TeamDisplay extends AppCompatActivity {

    TextView PlayerName1;
    TextView PlayerName2;
    TextView PlayerName3;
    TextView PlayerName4;
    TextView PlayerName5;
    TextView PlayerName6;
    TextView PlayerName7;
    TextView PlayerName8;
    TextView PlayerName9;
    TextView PlayerName10;
    TextView PlayerName11;
    TextView PlayerName12;
    TextView PlayerRole1;
    TextView PlayerRole2;
    TextView PlayerRole3;
    TextView PlayerRole4;
    TextView PlayerRole5;
    TextView PlayerRole6;
    TextView PlayerRole7;
    TextView PlayerRole8;
    TextView PlayerRole9;
    TextView PlayerRole10;
    TextView PlayerRole11;
    TextView PlayerRole12;
    TextView DisplayTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_display);

        PlayerName1 = (TextView) findViewById(R.id.phoneNo3);
        PlayerName2 = (TextView) findViewById(R.id.phoneNo5);
        PlayerName3 = (TextView) findViewById(R.id.phoneNo7);
        PlayerName4 = (TextView) findViewById(R.id.phoneNo9);
        PlayerName5 = (TextView) findViewById(R.id.phoneNo11);
        PlayerName6 = (TextView) findViewById(R.id.phoneNo13);
        PlayerName7 = (TextView) findViewById(R.id.phoneNo15);
        PlayerName8 = (TextView) findViewById(R.id.phoneNo17);
        PlayerName9 = (TextView) findViewById(R.id.phoneNo19);
        PlayerName10 = (TextView) findViewById(R.id.phoneNo21);
        PlayerName11 = (TextView) findViewById(R.id.phoneNo23);
        PlayerName12 = (TextView) findViewById(R.id.phoneNo25);
        PlayerRole1 = (TextView) findViewById(R.id.phoneNo4);
        PlayerRole2 = (TextView) findViewById(R.id.phoneNo6);
        PlayerRole3 = (TextView) findViewById(R.id.phoneNo8);
        PlayerRole4 = (TextView) findViewById(R.id.phoneNo10);
        PlayerRole5 = (TextView) findViewById(R.id.phoneNo12);
        PlayerRole6 = (TextView) findViewById(R.id.phoneNo14);
        PlayerRole7 = (TextView) findViewById(R.id.phoneNo16);
        PlayerRole8 = (TextView) findViewById(R.id.phoneNo18);
        PlayerRole9 = (TextView) findViewById(R.id.phoneNo20);
        PlayerRole10 = (TextView) findViewById(R.id.phoneNo22);
        PlayerRole11 = (TextView) findViewById(R.id.phoneNo24);
        PlayerRole12 = (TextView) findViewById(R.id.phoneNo26);
        DisplayTeam = (TextView) findViewById(R.id.PhoneNo);


        //Get Data Code

        String url = "http://192.168.10.14/SportHub/api/TeamPlayer/";
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("apicallres", response.toString());


                try {



                    for (int i = 0; i < response.length(); i++) {
                        JSONObject c = response.getJSONObject(i);
                        String a=Logic.TeamId.get(Logic.position);
                        String b=c.getString("TeamId").toString().trim();

                        if(a.equals(b)) {
                            PlayerName1.setText(c.getString("PlayerName1").toString().trim());
                            PlayerName2.setText(c.getString("PlayerName2").toString().trim());
                            PlayerName3.setText(c.getString("PlayerName3").toString().trim());
                            PlayerName4.setText(c.getString("PlayerName4").toString().trim());
                            PlayerName5.setText(c.getString("PlayerName5").toString().trim());
                            PlayerName6.setText(c.getString("PlayerName6").toString().trim());
                            PlayerName7.setText(c.getString("PlayerName7").toString().trim());
                            PlayerName8.setText(c.getString("PlayerName8").toString().trim());
                            PlayerName9.setText(c.getString("PlayerName9").toString().trim());
                            PlayerName10.setText(c.getString("PlayerName10").toString().trim());
                            PlayerName11.setText(c.getString("PlayerName11").toString().trim());
                            PlayerName12.setText(c.getString("PlayerName12").toString().trim());
                            PlayerRole1.setText(c.getString("PlayerRole1").toString().trim());
                            PlayerRole2.setText(c.getString("PlayerRole2").toString().trim());
                            PlayerRole3.setText(c.getString("PlayerRole3").toString().trim());
                            PlayerRole4.setText(c.getString("PlayerRole4").toString().trim());
                            PlayerRole5.setText(c.getString("PlayerRole5").toString().trim());
                            PlayerRole6.setText(c.getString("PlayerRole6").toString().trim());
                            PlayerRole7.setText(c.getString("PlayerRole7").toString().trim());
                            PlayerRole8.setText(c.getString("PlayerRole8").toString().trim());
                            PlayerRole9.setText(c.getString("PlayerRole9").toString().trim());
                            PlayerRole10.setText(c.getString("PlayerRole10").toString().trim());
                            PlayerRole11.setText(c.getString("PlayerRole11").toString().trim());
                            PlayerRole12.setText(c.getString("PlayerRole12").toString().trim());
                            DisplayTeam.setText(Logic.TeamName);

                        }
                        else {
                            int aa=0;
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(TeamDisplay.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, "");








    }
}
