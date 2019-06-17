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

    String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_players);

        // Player ONE Spinner

       /* player_role1 = (Spinner) findViewById(R.id.team_player_role1);

        List<String> player_role_list = new ArrayList<String>();
        player_role_list.add("Select Role");
        player_role_list.add("Batsman");
        player_role_list.add("Bowler");
        player_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player_role_list);
        role_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role1.setAdapter(role_arrayAdapter);


        player_role1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role1.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player TWO Spinner

        player_role2 = (Spinner) findViewById(R.id.team_player_role2);

        List<String> player2_role_list = new ArrayList<String>();
        player2_role_list.add("Select Role");
        player2_role_list.add("Batsman");
        player2_role_list.add("Bowler");
        player2_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role1_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player2_role_list);
        role_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role2.setAdapter(role1_arrayAdapter);


        player_role2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role2.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player THREE Spinner

        player_role3 = (Spinner) findViewById(R.id.team_player_role3);

        List<String> player3_role_list = new ArrayList<String>();
        player3_role_list.add("Select Role");
        player3_role_list.add("Batsman");
        player3_role_list.add("Bowler");
        player3_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role3_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player3_role_list);
        role3_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role3.setAdapter(role3_arrayAdapter);


        player_role3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role3.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player THREE Spinner

        player_role4 = (Spinner) findViewById(R.id.team_player_role4);

        List<String> player4_role_list = new ArrayList<String>();
        player4_role_list.add("Select Role");
        player4_role_list.add("Batsman");
        player4_role_list.add("Bowler");
        player4_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role4_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player4_role_list);
        role4_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role4.setAdapter(role4_arrayAdapter);


        player_role4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role4.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        // Player FIVE Spinner

        player_role5 = (Spinner) findViewById(R.id.team_player_role5);

        List<String> player5_role_list = new ArrayList<String>();
        player5_role_list.add("Select Role");
        player5_role_list.add("Batsman");
        player5_role_list.add("Bowler");
        player5_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role5_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player5_role_list);
        role5_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role5.setAdapter(role5_arrayAdapter);


        player_role5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role5.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player SIX Spinner

        player_role6 = (Spinner) findViewById(R.id.team_player_role6);

        List<String> player6_role_list = new ArrayList<String>();
        player6_role_list.add("Select Role");
        player6_role_list.add("Batsman");
        player6_role_list.add("Bowler");
        player6_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role6_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player6_role_list);
        role6_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role6.setAdapter(role6_arrayAdapter);


        player_role6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role6.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        // Player SEVEN Spinner

        player_role7 = (Spinner) findViewById(R.id.team_player_role7);

        List<String> player7_role_list = new ArrayList<String>();
        player7_role_list.add("Select Role");
        player7_role_list.add("Batsman");
        player7_role_list.add("Bowler");
        player7_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role7_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player7_role_list);
        role7_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role7.setAdapter(role7_arrayAdapter);


        player_role7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role7.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player EIGHT Spinner

        player_role8 = (Spinner) findViewById(R.id.team_player_role8);

        List<String> player8_role_list = new ArrayList<String>();
        player8_role_list.add("Select Role");
        player8_role_list.add("Batsman");
        player8_role_list.add("Bowler");
        player8_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role8_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player8_role_list);
        role8_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role8.setAdapter(role8_arrayAdapter);


        player_role8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role8.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player NINE Spinner


        player_role9 = (Spinner) findViewById(R.id.team_player_role9);

        List<String> player9_role_list = new ArrayList<String>();
        player9_role_list.add("Select Role");
        player9_role_list.add("Batsman");
        player9_role_list.add("Bowler");
        player9_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role9_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player9_role_list);
        role9_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role9.setAdapter(role9_arrayAdapter);


        player_role9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role9.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player TEN Spinner

        player_role10 = (Spinner) findViewById(R.id.team_player_role10);

        List<String> player10_role_list = new ArrayList<String>();
        player10_role_list.add("Select Role");
        player10_role_list.add("Batsman");
        player10_role_list.add("Bowler");
        player10_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role10_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player10_role_list);
        role10_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role10.setAdapter(role10_arrayAdapter);


        player_role10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role10.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        // Player ELEVEN Spinner

        player_role11 = (Spinner) findViewById(R.id.team_player_role11);

        List<String> player11_role_list = new ArrayList<String>();
        player11_role_list.add("Select Role");
        player11_role_list.add("Batsman");
        player11_role_list.add("Bowler");
        player11_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role11_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player11_role_list);
        role11_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role11.setAdapter(role11_arrayAdapter);


        player_role11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role11.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        // Player TWELVE Spinner


        player_role12 = (Spinner) findViewById(R.id.team_player_role12);

        List<String> player12_role_list = new ArrayList<String>();
        player12_role_list.add("Select Role");
        player12_role_list.add("Batsman");
        player12_role_list.add("Bowler");
        player12_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role12_arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, player12_role_list);
        role12_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role12.setAdapter(role12_arrayAdapter);


        player_role12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                player_role12.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });*/


        // API Post Data

       /* String url = "http://192.168.100.128/SportHub/api/TeamPlayer/";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.


                Toast SavedToast = Toast.makeText(TeamPlayers.this, response.toString(), Toast.LENGTH_SHORT);
                SavedToast.show();

                Intent intent = new Intent(TeamPlayers.this, Signup.class);
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

                object.put("PlayerRole1", player_role1.getSelectedItem().toString().trim());
                object.put("PlayerRole2", player_role2.getSelectedItem().toString().trim());
                object.put("PlayerRole3", player_role3.getSelectedItem().toString().trim());
                object.put("PlayerRole4", player_role4.getSelectedItem().toString().trim());
                object.put("PlayerRole5", player_role5.getSelectedItem().toString().trim());
                object.put("PlayerRole6", player_role6.getSelectedItem().toString().trim());
                object.put("PlayerRole7", player_role7.getSelectedItem().toString().trim());
                object.put("PlayerRole8", player_role8.getSelectedItem().toString().trim());
                object.put("PlayerRole9", player_role9.getSelectedItem().toString().trim());
                object.put("PlayerRole10", player_role10.getSelectedItem().toString().trim());
                object.put("PlayerRole11", player_role11.getSelectedItem().toString().trim());
                object.put("PlayerRole12", player_role12.getSelectedItem().toString().trim());


                // object.put("City",City.getSelectedItem().toString().trim());


                /*object.put("Type",Type.getSelectedItem().toString().trim());
                object.put("Type","Type");
                object.put("Monday",Monday);
                object.put("Tuesday",Tuesday);
                object.put("Wednesday",Wednesday);
                object.put("Thursday",Thursday);
                object.put("Friday",Friday);
                object.put("Saturday",Saturday);
                object.put("Sunday",Sunday);
                object.put("UserName",Sunday);
                object.put("Password",Sunday);
                return object;


            }
        };
        AppController.getInstance().addToRequestQueue(MyStringRequest, "");*/



       //Spiner Code


        Spinner spinner1 = (Spinner) findViewById(R.id.team_player_role1);
        Spinner spinner2 = (Spinner) findViewById(R.id.team_player_role2);
        Spinner spinner3 = (Spinner) findViewById(R.id.team_player_role3);
        Spinner spinner4 = (Spinner) findViewById(R.id.team_player_role4);
        Spinner spinner5 = (Spinner) findViewById(R.id.team_player_role5);
        Spinner spinner6= (Spinner) findViewById(R.id.team_player_role6);
        Spinner spinner7 = (Spinner) findViewById(R.id.team_player_role7);
        Spinner spinner8 = (Spinner) findViewById(R.id.team_player_role8);
        Spinner spinner9 = (Spinner) findViewById(R.id.team_player_role9);
        Spinner spinner10= (Spinner) findViewById(R.id.team_player_role10);
        Spinner spinner11= (Spinner) findViewById(R.id.team_player_role11);
        Spinner spinner12 = (Spinner) findViewById(R.id.team_player_role12);

        // (2) create a simple static list of strings
        final List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Select Sport");


        //Get Data


        String urll = "http://192.168.0.7/SportHub/api/PlayerRole/";
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


