package com.tritechteal.sport_hub.OraganizeTournament;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tritechteal.sport_hub.AppController;
import com.tritechteal.sport_hub.PlayerSignUp;
import com.tritechteal.sport_hub.R;
import com.tritechteal.sport_hub.Signup;
import com.tritechteal.sport_hub.TeamPlayers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterTeam extends AppCompatActivity {
    //Spinner Variables
    Spinner select_team_sport;
    Spinner selct_city;
    Spinner select_area;

    // API Variables
    EditText team_name;
    Spinner team_sport;
    Spinner team_city;
    Spinner team_area;
    EditText team_phone_no;
    Button team_register;

    // Register for players button
    Button add_player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_team);

        add_player = (Button) findViewById(R.id.register_team);

        add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegisterTeam.this, TeamPlayers.class);
                startActivity(intent);
            }
        });

        // END Register for player button

        select_team_sport = (Spinner) findViewById(R.id.select_team_sport);

        List<String> select_sport_list=new ArrayList<String>();
        select_sport_list.add("Select Sport");
        select_sport_list.add("Cricket");
        select_sport_list.add("football");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select_sport_list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_team_sport.setAdapter(arrayAdapter);


        select_team_sport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                select_team_sport.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        selct_city = (Spinner) findViewById(R.id.select_team_city);

        List<String> select_city_list=new ArrayList<String>();
        select_city_list.add("Select Ciy");
        select_city_list.add("Islamabad");
        select_city_list.add("Rawalpindi");

        ArrayAdapter<String> arrayAdapter_city=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select_city_list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selct_city.setAdapter(arrayAdapter_city);


        selct_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                selct_city.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });
        select_area = (Spinner) findViewById(R.id.select_team_area);

        List<String> select_area_list=new ArrayList<String>();
        select_area_list.add("Select Area");
        select_area_list.add("Chakshazad");
        select_area_list.add("Rawal Town");
        select_area_list.add("Chatta Bakhtawar");

        ArrayAdapter<String> arrayAdapter_area=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select_area_list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_area.setAdapter(arrayAdapter_area);


        select_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                select_area.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });
        team_name= (EditText) findViewById(R.id.teannametextbox);
        team_sport= (Spinner) findViewById(R.id.select_team_sport);
        team_city= (Spinner) findViewById(R.id.select_team_city);
        team_area= (Spinner) findViewById(R.id.select_team_area);
        team_phone_no = (EditText) findViewById(R.id.team_cellno);
        team_register= (Button) findViewById(R.id.register_team);

        String url = "http://192.168.0.121/SportHub/api/TeamInfo/";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.


                Toast SavedToast = Toast.makeText(RegisterTeam.this, response.toString(), Toast.LENGTH_SHORT);
                SavedToast.show();

                Intent intent=new Intent(RegisterTeam.this, Signup.class);
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
                object.put("TeamName",team_name.getText().toString().trim());
                object.put("TeamSport",team_sport.getSelectedItem().toString().trim());
                object.put("CityName",team_city.getSelectedItem().toString().trim());
                object.put("TeamArea",team_area.getSelectedItem().toString().trim());
                object.put("PhoneNo",team_phone_no.getText().toString().trim());
                return object;



            }
        };
        AppController.getInstance().addToRequestQueue(MyStringRequest, "");
    }
}



