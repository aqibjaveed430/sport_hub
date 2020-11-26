package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class CapitanSignup extends AppCompatActivity {

    // For API data
    EditText captan_username;
    EditText captan_name;
    EditText captan_password;
    EditText captan_cellno;

    //Post Data
    EditText captain_user;
    EditText captain_name;
    EditText captaain_pasword;
    Spinner captain_sport;
    Button cpatain_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitan_signup);

        // Data Get Start


        captan_username = (EditText) findViewById(R.id.username_capitan);
        captan_name = (EditText) findViewById(R.id.capitanname);
        captan_password = (EditText) findViewById(R.id.capitan_password);
        captan_cellno = (EditText) findViewById(R.id.cellno);
        cpatain_register = (Button) findViewById(R.id.signup_capitn_btn);



        cpatain_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.10.174/SportHub/api/RegisterCaptain/";
                StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //This code is executed if the server responds, whether or not the response contains data.
                        //The String 'response' contains the server's response.


                        Toast SavedToast = Toast.makeText(CapitanSignup.this, response.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                        Intent intent = new Intent(CapitanSignup.this, LoginActivity.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //This code is executed if there is an error.
                        Toast SavedToast = Toast.makeText(CapitanSignup.this, error.toString(), Toast.LENGTH_SHORT);
                        SavedToast.show();

                    }
                }) {
                    protected Map<String, String> getParams() {


                        Map<String, String> object = new HashMap<String, String>();
                        object.put("CapitanUserName", captan_username.getText().toString().trim());
                        object.put("CapitanName", captan_name.getText().toString().trim());
                        object.put("CapitanPassword", captan_password.getText().toString().trim());
                        object.put("CaptainSport", captan_cellno.getText().toString().trim());
                        return object;


                    }
                };
                AppController.getInstance().addToRequestQueue(MyStringRequest, "");
                Intent intent = new Intent(CapitanSignup.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}