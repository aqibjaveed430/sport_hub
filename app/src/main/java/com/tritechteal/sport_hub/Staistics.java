package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tritechteal.sport_hub.R;

import java.util.HashMap;
import java.util.Map;

public class Staistics extends AppCompatActivity {
EditText stat_team_name;
EditText total_match;
EditText win_match;
EditText lose_match;
EditText total_point;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staistics);

        stat_team_name = (EditText) findViewById(R.id.stat_teamname);
        total_match = (EditText) findViewById(R.id.stat_totalmatches);
        win_match = (EditText) findViewById(R.id.stat_winmatch);
        lose_match = (EditText) findViewById(R.id.stat_losematch);
        total_point = (EditText) findViewById(R.id.totalpoint);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.10.3/SportHub/api/TeamMatchStats/";
                StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //This code is executed if the server responds, whether or not the response contains data.
                        //The String 'response' contains the server's response.


                        Toast SavedToast = Toast.makeText(Staistics.this, response.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                        Intent intent = new Intent(Staistics.this, LoginActivity.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //This code is executed if there is an error.
                        Toast SavedToast = Toast.makeText(Staistics.this, error.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                    }
                }) {
                    protected Map<String, String> getParams() {


                        Map<String, String> object = new HashMap<String, String>();
                        object.put("StatTeamName", stat_team_name.getText().toString().trim());
                        object.put("TotalMatches", total_match.getText().toString().trim());
                        object.put("LoseMaatch", lose_match.getText().toString().trim());
                        object.put("WinMatch", win_match.getText().toString().trim());
                        object.put("TotalPoint", total_point.getText().toString().trim());
                        return object;


                    }
                };
                AppController.getInstance().addToRequestQueue(MyStringRequest, "");

                Intent intent = new Intent(Staistics.this, TeamPlayers.class);
                startActivity(intent);
            }
        });
    }
}
