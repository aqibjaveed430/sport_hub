package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tritechteal.sport_hub.MainHome.Dashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerSignUp extends AppCompatActivity {
// spinner variables
    Spinner select_sport;
    Spinner select_city;
    Spinner select_role;
    Spinner select_area;

//API data
    EditText pname;
    EditText phoneno;
    Spinner Sport;
    Spinner City;
    Spinner CityArea;
    Spinner Type;

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

        select_city = (Spinner) findViewById(R.id.seletcity);

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

        });

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

        select_area = (Spinner) findViewById(R.id.areaspinner);

        List<String> selectarea=new ArrayList<String>();
        selectarea.add("Select Area");
        selectarea.add("Chak Shazad");
        selectarea.add("Alipur");
        selectarea.add("G/10");
        selectarea.add("I/9");

        ArrayAdapter<String> arrayAdapter_area=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,selectarea);
        arrayAdapter_area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_area.setAdapter(arrayAdapter_area);


        select_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
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
        phoneno= (EditText) findViewById(R.id.plaermobileno);
        Sport= (Spinner) findViewById(R.id.selectsport);
        City= (Spinner) findViewById(R.id.seletcity);
        CityArea= (Spinner) findViewById(R.id.areaspinner);
      //  Type= (Spinner) findViewById(R.id.SelectType);
        Mon= (CheckBox) findViewById(R.id.mondaycheckBox);
        Tue= (CheckBox) findViewById(R.id.tuesdaycheckBox);
        Wed= (CheckBox) findViewById(R.id.wednesdaycheckBox);
        Thurs= (CheckBox) findViewById(R.id.thursdaycheckBox);
        Fri= (CheckBox) findViewById(R.id.fridaycheckBox);
        Sat= (CheckBox) findViewById(R.id.saturdaycheckBox);
        Sun=   (CheckBox) findViewById(R.id.sundaycheckBox);

        Register =(Button) findViewById(R.id.signuppalyer);





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


                String url = "http://192.168.0.121/SportHub/api/PlayerInfo/";
                StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //This code is executed if the server responds, whether or not the response contains data.
                        //The String 'response' contains the server's response.


                        Toast SavedToast = Toast.makeText(PlayerSignUp.this, response.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                        Intent intent=new Intent(PlayerSignUp.this, Signup.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //This code is executed if there is an error.
                        Toast SavedToast = Toast.makeText(PlayerSignUp.this, error.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                    }
                }) {
                    protected Map<String, String> getParams() {



                         Map<String, String> object = new HashMap<String, String>();
                        object.put("PlayerName",pname.getText().toString().trim());
                        object.put("PlayerPhoneNo",phoneno.getText().toString().trim());
                        object.put("Sport",Sport.getSelectedItem().toString().trim());
                        object.put("City",City.getSelectedItem().toString().trim());
                      //  object.put("Type",Type.getSelectedItem().toString().trim());
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
                AppController.getInstance().addToRequestQueue(MyStringRequest, "");
            }
        });




    }


    }




