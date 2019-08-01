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

public class RegisterTeam extends AppCompatActivity {
    //Spinner Variables
    Spinner select_team_sport;

    Spinner select_area;

    // API Variables
    EditText team_name;
    Spinner team_sport;
    Spinner team_city;
    Spinner team_area;
    EditText team_phone_no;
    Button team_register;
    String sport;
   public static TextView select_city;

    // Register for players button
    Button add_player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_team);
        select_city = (TextView) findViewById(R.id.select_cityname);


        team_name=(EditText) findViewById(R.id.teannametextbox);
        add_player = (Button) findViewById(R.id.register_team);
        team_sport = (Spinner) findViewById(R.id.select_team_sport);
        select_city = (TextView) findViewById(R.id.select_cityname);
        team_phone_no = (EditText) findViewById(R.id.team_cellno);

        select_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logic.city_seletion = "Team";
                Intent intent = new Intent(RegisterTeam.this, PlacePickerr.class);
                startActivity(intent);
            }
        });

        add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.10.14/SportHub/api/RegisterTeam/";
                StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //This code is executed if the server responds, whether or not the response contains data.
                        //The String 'response' contains the server's response.


                        Toast SavedToast = Toast.makeText(RegisterTeam.this, response.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                        Intent intent = new Intent(RegisterTeam.this, TeamPlayers.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //This code is executed if there is an error.
                        Toast SavedToast = Toast.makeText(RegisterTeam.this, error.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                    }
                }) {
                    protected Map<String, String> getParams() {


                        Map<String, String> object = new HashMap<String, String>();
                        object.put("TeamName", team_name.getText().toString().trim());
                        object.put("TeamSport", team_sport.getSelectedItem().toString().trim());
                        object.put("CityName", select_city.getText().toString().trim());
                        object.put("PhoneNo", team_phone_no.getText().toString().trim());
                        return object;


                    }
                };
                AppController.getInstance().addToRequestQueue(MyStringRequest, "");

            }
        });

        // END Register for player button








        // Spinner Code

        Spinner spinner1 = (Spinner) findViewById(R.id.select_team_sport);

        // (2) create a simple static list of strings
        final List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Select Sport");


        //Get Data


        String urll = "http://192.168.10.14/SportHub/api/Sport/";
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, urll, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("apicallres", response.toString());

                try {

                    int a = 0;
                    for (int i = 0; i < response.length(); i++) {
                        a = 1;
                        JSONObject c = response.getJSONObject(i);
                        spinnerArray.add(c.getString("SportName").toString().trim());


                    }

                    if (a == 0) {
                        Toast errorToast = Toast.makeText(RegisterTeam.this, "No Data Found ", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(RegisterTeam.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
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


        //Spinner click event function

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();

                    if (selectedItemText.equals("Cricket")){
                        Logic.sports="1";
                    }
                    else if (selectedItemText.equals("Football")){
                        Logic.sports="2";
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
                }
            }






