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
    Spinner capitan_select_sport;
    // For API data
    EditText captan_username;
    EditText captan_name;
    EditText captan_password;
    Spinner captan_sport;

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


       /* String url = "http://192.168.100.128/SportHub/api/RegisterCaptain/";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.




                Intent intent = new Intent(CapitanSignup.this,LoginActivity .class);
                startActivity(intent);

                Toast SavedToast = Toast.makeText(CapitanSignup.this, response.toString(), Toast.LENGTH_SHORT);
                SavedToast.show();
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
                object.put("CaptainSport", capitan_select_sport.getSelectedItem().toString().trim());
                //  object.put("Type",Type.getSelectedItem().toString().trim());
                //object.put("Type","Type");

                return object;


            }
        };
        captain_user = (EditText) findViewById(R.id.username_capitan);
        captain_name = (EditText) findViewById(R.id.capitanname);
        captaain_pasword = (EditText) findViewById(R.id.capitan_password);
     //   captain_sport = (Spinner) findViewById(R.id.captain_slectsport);
        cpatain_register = (Button) findViewById(R.id.signup_capitn_btn);


    }}*/

       /* cpatain_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject object = new JSONObject();
                //    u1.UserName=UserName.getText().toString().trim();
                //  u1.Password=Password.getText().toString().trim();

             /*   String url = "http://192.168.10.3/SportHub/api/PlayerInfo/";
                JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("apicallres", response.toString());


                        try {

                            //            JSONObject json=new JSONObject((Map) response);
                            //          JSONArray User = json.getJSONArray("UserInfo");

                            int a=0;
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject c = response.getJSONObject(i);
                                String Username = c.getString("UserName").toString().trim();
                                String Password = c.getString("Password").toString().trim();
                                if (Username.equals(captain_user.getText().toString().trim())&&Password.equals(captaain_pasword.getText().toString().trim())) {
                                    a=1;
                                    Intent intent = new Intent(CapitanSignup.this, ForgetPassword.class);
                                    startActivity(intent);
                                    break;
                                }
                            }

                            if(a==0) {
                                Toast errorToast = Toast.makeText(CapitanSignup.this, "UserName Or Password is Incorrect ", Toast.LENGTH_SHORT);
                                errorToast.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast errorToast = Toast.makeText(CapitanSignup.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }
                });
        AppController.getInstance().addToRequestQueue(MyStringRequest, "");

                               // Data Get END

        }
}*/

    }
}