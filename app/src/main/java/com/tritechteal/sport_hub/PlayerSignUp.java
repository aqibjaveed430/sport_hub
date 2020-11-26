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
import android.widget.CheckBox;
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

public class PlayerSignUp extends AppCompatActivity {
// spinner variables
    Spinner select_sport;
    TextView select_city;
    Spinner select_role;
    Spinner select_area;
    public static TextView city_name;
    String sport;
    String Role;

//API data
    EditText username;
    EditText pname;
    EditText phoneno;
    EditText password;
    Spinner Sport;
    public static TextView City;
    Spinner CityArea;
    Spinner role;


   // Spinner Type;

    CheckBox Mon;
    CheckBox Tue;
    CheckBox Wed;
    CheckBox Thurs;
    CheckBox Fri;
    CheckBox Sat;
    CheckBox Sun;
    Button Register;


    String Monday="No";
    String Tuesday="No";
    String Friday="No";
    String Saturday="No";
    String Wednesday="No";
    String Thursday="No";
    String Sunday="No";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_sign_up);

        city_name = (TextView) findViewById(R.id.select_city_name);

        city_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logic.city_seletion = "Team";
                Intent intent = new Intent(PlayerSignUp.this, PlacePickerr.class);
                startActivity(intent);
            }
        });

        select_sport = (Spinner) findViewById(R.id.selectsport);

        List<String> select_sport_list=new ArrayList<String>();
        select_sport_list.add("Select Sport");
        select_sport_list.add("Cricket");
        select_sport_list.add("football");

        ArrayAdapter<String> arrayAdapter_sport=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select_sport_list);
        arrayAdapter_sport.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_sport.setAdapter(arrayAdapter_sport);


        select_sport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,int i,long l)
            {

                select_sport.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

       /* select_city = (Spinner) findViewById(R.id.seletcity);

        List<String> select_city_list=new ArrayList<String>();
        select_city_list.add("Select City");
        select_city_list.add("Islamabad");
        select_city_list.add("Rawalpindi");

        ArrayAdapter<String> arrayAdapter_city=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select_city_list);
        arrayAdapter_city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_city.setAdapter(arrayAdapter_city);


        select_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,int i,long l)
            {

                select_city.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });*/

        select_role = (Spinner) findViewById(R.id.seletrole);

        List<String> selectrole=new ArrayList<String>();
        selectrole.add("Select Role");
        selectrole.add("Captan");
        selectrole.add("Batsman");
        selectrole.add("Bowler");

        ArrayAdapter<String> arrayAdapter_role=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,selectrole);
        arrayAdapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_role.setAdapter(arrayAdapter_role);


        select_role.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,int i,long l)
            {

                select_role.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });





        pname= (EditText) findViewById(R.id.playerfullname);
        password= (EditText) findViewById(R.id.playerpassword);
        phoneno= (EditText) findViewById(R.id.plaermobileno);
        Sport= (Spinner) findViewById(R.id.selectsport);

        City= (TextView) findViewById(R.id.select_city_name);
        City.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logic.city_seletion="Player";
                Intent intent= new Intent(PlayerSignUp.this, PlacePickerr.class);
                startActivity(intent);


            }
        });
       // CityArea= (Spinner) findViewById(R.id.areaspinner);
        role= (Spinner) findViewById(R.id.seletrole);
        username= (EditText) findViewById(R.id.username);


        //  Type= (Spinner) findViewById(R.id.SelectType);
        Mon= (CheckBox) findViewById(R.id.mondaycheckBox);
        Tue= (CheckBox) findViewById(R.id.tuesdaycheckBox);
        Wed= (CheckBox) findViewById(R.id.wednesdaycheckBox);
        Thurs= (CheckBox) findViewById(R.id.thursdaycheckBox);
        Fri= (CheckBox) findViewById(R.id.fridaycheckBox);
        Sat= (CheckBox) findViewById(R.id.saturdaycheckBox);
        Sun=   (CheckBox) findViewById(R.id.sundaycheckBox);
        Register =(Button) findViewById(R.id.nextbtn);





        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(Mon.isChecked())
                {
                    Monday="Yes";
                }

                if(Tue.isChecked())
                {
                    Tuesday="Yes";
                }

                if(Wed.isChecked())
                {
                    Wednesday="Yes";
                }

                if(Thurs.isChecked())
                {
                    Thursday="Yes";
                }

                if(Fri.isChecked())
                {
                    Friday="Yes";
                }

                if(Sat.isChecked())
                {
                    Saturday="Yes";
                }

                if(Sun.isChecked())
                {
                    Sunday="Yes";
                }
                Logic.player.PlayerName=pname.getText().toString().trim();
                Logic.player.PlayerPhoneNo=phoneno.getText().toString().trim();
                Logic.player.Sport=Sport.getSelectedItem().toString().trim();
                Logic.player.Role=select_role.getSelectedItem().toString().trim();
                Logic.player.City=City.getText().toString().trim();
                Logic.player.Monday=Monday;
                Logic.player.Tuesday=Tuesday;
                Logic.player.Wednesday=Wednesday;
                Logic.player.Thursday=Thursday;
                Logic.player.Friday=Friday;
                Logic.player.Saturday=Saturday;
                Logic.player.Sunday=Sunday;
                Logic.player.UserName=username.getText().toString().trim();
                Logic.player.Password=password.getText().toString().trim();

                Intent intent= new Intent(PlayerSignUp.this, UploadPhoto.class);
                startActivity(intent);










            }
        });

         //Spinner Code


        Spinner spinner1 = (Spinner) findViewById(R.id.selectsport);

        // (2) create a simple static list of strings
        final List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Select Sport");


        //Get Data


        String urll = "http://192.168.10.74/SportHub/api/Sport/";
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
                        Toast errorToast = Toast.makeText(PlayerSignUp.this, "No Data Found ", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast errorToast = Toast.makeText(PlayerSignUp.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
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

        // (2) create a simple static list of strings
        final Spinner spinner2 = (Spinner) findViewById(R.id.seletrole);
        final List<String> spinnerArray2 = new ArrayList<>();
        spinnerArray2.add("Select Role");



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
                    sport = selectedItemText;



                    //Get Data
                    spinnerArray2.clear();
                    spinnerArray2.add("Select Role");
                    spinner2.setSelection(0);

                    String urll = "http://192.168.10.3/SportHub/api/PlayerRole/";
                    JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, urll, null, new Response.Listener<JSONArray>() {

                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d("apicallres", response.toString());

                            try {

                                int a = 0;
                                String res = Integer.toString(position);
                                for (int i = 0; i < response.length(); i++) {
                                    a = 1;
                                    JSONObject c = response.getJSONObject(i);
                                    if (res.equals(c.getString("SportId").trim())){
                                        spinnerArray2.add(c.getString("RoleName").toString().trim());
                                    }
                                }


                                if (a == 0) {
                                    Toast errorToast = Toast.makeText(PlayerSignUp.this, "No Data Found ", Toast.LENGTH_SHORT);
                                    errorToast.show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast errorToast = Toast.makeText(PlayerSignUp.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                            errorToast.show();
                        }
                    });

// Adding request to request queue
                    AppController.getInstance().addToRequestQueue(jsonObjReq, "");

                    // (3) create an adapter from the list

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray2) {
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
        spinner2.setAdapter(adapterr);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();

                   Role=selectedItemText;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    }







