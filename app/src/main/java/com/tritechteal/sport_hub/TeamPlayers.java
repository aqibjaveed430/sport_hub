package com.tritechteal.sport_hub;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamPlayers extends AppCompatActivity {
    Spinner player_role1;
    Spinner player_role2;
    Spinner player_role3;
    Spinner player_role4;
    Spinner player_role5;
    Spinner player_role6;
    Spinner player_role7;
    Spinner player_role8;
    Spinner player_role9;
    Spinner player_role10;
    Spinner player_role11;
    Spinner player_role12;



    String TeamID;


    // INSERT DATA Player NAMES

    EditText player_name1;
    EditText player_name2;
    EditText player_name3;
    EditText player_name4;
    EditText player_name5;
    EditText player_name6;
    EditText player_name7;
    EditText player_name8;
    EditText player_name9;
    EditText player_name10;
    EditText player_name11;
    EditText player_name12;


    // Variable fOR Player Mobile Numbers

    EditText player_cellno1;
    EditText player_cellno2;
    EditText player_cellno3;
    EditText player_cellno4;
    EditText player_cellno5;
    EditText player_cellno6;
    EditText player_cellno7;
    EditText player_cellno8;
    EditText player_cellno9;
    EditText player_cellno10;
    EditText player_cellno11;
    EditText player_cellno12;
    Button team_reg;

    String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_players);


        player_name1 = (EditText) findViewById(R.id.NamePlayer1);
        player_name2 = (EditText) findViewById(R.id.Name_Player2);
        player_name3 = (EditText) findViewById(R.id.Name_Player3);
        player_name4 = (EditText) findViewById(R.id.Name_Player4);
        player_name5 = (EditText) findViewById(R.id.Name_Player5);
        player_name6 = (EditText) findViewById(R.id.Name_Player6);
        player_name7 = (EditText) findViewById(R.id.Name_Player7);
        player_name8 = (EditText) findViewById(R.id.Name_Player8);
        player_name9 = (EditText) findViewById(R.id.Name_Player9);
        player_name10 = (EditText) findViewById(R.id.Name_Player10);
        player_name11 = (EditText) findViewById(R.id.Name_Player11);
        player_name12 = (EditText) findViewById(R.id.Name_Player12);


        player_cellno1 = (EditText) findViewById(R.id.CellNo_Player1);
        player_cellno2 = (EditText) findViewById(R.id.CellNo_Player2);
        player_cellno3 = (EditText) findViewById(R.id.CellNo_Player3);
        player_cellno4 = (EditText) findViewById(R.id.CellNo_Player4);
        player_cellno5 = (EditText) findViewById(R.id.CellNo_Player5);
        player_cellno6 = (EditText) findViewById(R.id.CellNo_Player6);
        player_cellno7 = (EditText) findViewById(R.id.CellNo_Player7);
        player_cellno8 = (EditText) findViewById(R.id.CellNo_Player8);
        player_cellno9 = (EditText) findViewById(R.id.CellNo_Player9);
        player_cellno10 = (EditText) findViewById(R.id.CellNo_Player10);
        player_cellno11 = (EditText) findViewById(R.id.CellNo_Player11);
        player_cellno12 = (EditText) findViewById(R.id.CellNo_Player12);
        team_reg = (Button) findViewById(R.id.Team_Register_Btn);


//Spinner

        final Spinner spinner1 = (Spinner) findViewById(R.id.team_player_role1);
        final  Spinner spinner2 = (Spinner) findViewById(R.id.team_player_role2);
        final  Spinner spinner3 = (Spinner) findViewById(R.id.team_player_role3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.team_player_role4);
        final Spinner spinner5 = (Spinner) findViewById(R.id.team_player_role5);
        final  Spinner spinner6= (Spinner) findViewById(R.id.team_player_role6);
        final Spinner spinner7 = (Spinner) findViewById(R.id.team_player_role7);
        final Spinner spinner8 = (Spinner) findViewById(R.id.team_player_role8);
        final Spinner spinner9 = (Spinner) findViewById(R.id.team_player_role9);
        final Spinner spinner10= (Spinner) findViewById(R.id.team_player_role10);
        final Spinner spinner11= (Spinner) findViewById(R.id.team_player_role11);
        final Spinner spinner12 = (Spinner) findViewById(R.id.team_player_role12);



        //TeamId get



        String urlll = "http://192.168.10.10/SportHub/api/RegisterTeam/";
        JsonArrayRequest jsonObjReq2 = new JsonArrayRequest(Request.Method.GET, urlll, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("apicallres", response.toString());

                try {

                        JSONObject c = response.getJSONObject(response.length()-1);
                        TeamID=c.getString("TeamId").toString().trim();






                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(TeamPlayers.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq2, "");









        //post///////
        team_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.10.14/SportHub/api/TeamPlayer/";
                StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //This code is executed if the server responds, whether or not the response contains data.
                        //The String 'response' contains the server's response.


                        Toast SavedToast = Toast.makeText(TeamPlayers.this, response.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                        Intent intent = new Intent(TeamPlayers.this, Dashboard.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //This code is executed if there is an error.
                        Toast SavedToast = Toast.makeText(TeamPlayers.this, error.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                    }
                }) {
                    protected Map<String, String> getParams() {


                        Map<String, String> object = new HashMap<String, String>();
                        object.put("PlayerName1", player_name1.getText().toString().trim());
                        object.put("PlayerName2", player_name2.getText().toString().trim());
                        object.put("PlayerName3", player_name3.getText().toString().trim());
                        object.put("PlayerName4", player_name4.getText().toString().trim());
                        object.put("PlayerName5", player_name5.getText().toString().trim());
                        object.put("PlayerName6", player_name5.getText().toString().trim());
                        object.put("PlayerName7", player_name6.getText().toString().trim());
                        object.put("PlayerName8", player_name7.getText().toString().trim());
                        object.put("PlayerName9", player_name8.getText().toString().trim());
                        object.put("PlayerName10", player_name9.getText().toString().trim());
                        object.put("PlayerName11", player_name10.getText().toString().trim());
                        object.put("PlayerName12", player_name11.getText().toString().trim());

                        object.put("PlayerCellNo1", player_cellno1.getText().toString().trim());
                        object.put("PlayerCellNo2", player_cellno2.getText().toString().trim());
                        object.put("PlayerCellNo3", player_cellno3.getText().toString().trim());
                        object.put("PlayerCellNo4", player_cellno4.getText().toString().trim());
                        object.put("PlayerCellNo5", player_cellno5.getText().toString().trim());
                        object.put("PlayerCellNo6", player_cellno6.getText().toString().trim());
                        object.put("PlayerCellNo7", player_cellno7.getText().toString().trim());
                        object.put("PlayerCellNo8", player_cellno8.getText().toString().trim());
                        object.put("PlayerCellNo9", player_cellno9.getText().toString().trim());
                        object.put("PlayerCellNo10", player_cellno10.getText().toString().trim());
                        object.put("PlayerCellNo11", player_cellno11.getText().toString().trim());
                        object.put("PlayerCellNo12", player_cellno12.getText().toString().trim());



                        object.put("PlayerRole1",spinner1 .getSelectedItem().toString().trim());
                        object.put("PlayerRole2", spinner2 .getSelectedItem().toString().trim());
                        object.put("PlayerRole3", spinner3 .getSelectedItem().toString().trim());
                        object.put("PlayerRole4", spinner4 .getSelectedItem().toString().trim());
                        object.put("PlayerRole5", spinner5 .getSelectedItem().toString().trim());
                        object.put("PlayerRole6", spinner6 .getSelectedItem().toString().trim());
                        object.put("PlayerRole7", spinner7 .getSelectedItem().toString().trim());
                        object.put("PlayerRole8", spinner8 .getSelectedItem().toString().trim());
                        object.put("PlayerRole9", spinner9.getSelectedItem().toString().trim());
                        object.put("PlayerRole10", spinner10 .getSelectedItem().toString().trim());
                        object.put("PlayerRole11", spinner11 .getSelectedItem().toString().trim());
                        object.put("PlayerRole12", spinner12 .getSelectedItem().toString().trim());
                        object.put("TeamId", TeamID);


                        return object;


                    }
                };
                AppController.getInstance().addToRequestQueue(MyStringRequest, "");

            }
        });

       //Spiner Code



        // (2) create a simple static list of strings
        final List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Select Sport");


        //Get Data


        String urll = "http://192.168.10.10/SportHub/api/PlayerRole/";
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, urll, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("apicallres", response.toString());

                try {

                    int a = 0;
                    for (int i = 0; i < response.length(); i++) {
                        a = 1;
                        JSONObject c = response.getJSONObject(i);
                        if (Logic.sports.equals(c.getString("SportId").toString().trim())){
                            spinnerArray.add(c.getString("RoleName").toString().trim());
                        }
                    }


                    if (a == 0) {
                        Toast errorToast = Toast.makeText(TeamPlayers.this, "No Data Found ", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(TeamPlayers.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, "");

        // (3) create an adapter from the list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                spinnerArray
        ) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };


//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// (4) set the adapter on the spinner
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter);
        spinner9.setAdapter(adapter);
        spinner10.setAdapter(adapter);
        spinner11.setAdapter(adapter);
        spinner12.setAdapter(adapter);


        }
}


