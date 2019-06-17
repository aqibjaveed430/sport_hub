package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText user_email;
    EditText user_password;
    RadioButton organizer;
    RadioButton team;
    RadioButton player;
    CheckBox remember_me;
    TextView password_forget;
    Button signin_button;
    Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button code for Next Activity

        sign_up = (Button) findViewById(R.id.signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, SelectLogin.class);
                startActivity(intent);
            }
        });

        password_forget = (TextView) findViewById(R.id.forget_password);
        password_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });




        user_email= (EditText) findViewById(R.id.sigin_email);
        user_password= (EditText) findViewById(R.id.sigin_pasword);
        organizer= (RadioButton) findViewById(R.id.organizer_radioButton);
        team= (RadioButton) findViewById(R.id.teamradioButton);
        player= (RadioButton) findViewById(R.id.PlayerradioButton);
        remember_me= (CheckBox) findViewById(R.id.remember_me);
        password_forget= (TextView) findViewById(R.id.forget_password);
        signin_button= (Button) findViewById(R.id.signin);
        //sign_up= (Button) findViewById(R.id.signup);



        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject object = new JSONObject();
            //    u1.UserName=UserName.getText().toString().trim();
              //u1.Password=Password.getText().toString().trim();

                String url = "http://192.168.0.7/SportHub/api/PlayerInfo/";
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
                                if (Username.equals(user_email.getText().toString().trim())&&Password.equals(user_password.getText().toString().trim())) {
                                    a=1;
                                    Logic.user_img = c.getString("PlayerImage").toString().trim();
                                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                                    startActivity(intent);
                                    break;
                                }
                            }

                            if(a==0) {
                                Toast errorToast = Toast.makeText(LoginActivity.this, "UserName Or Password is Incorrect ", Toast.LENGTH_SHORT);
                                errorToast.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast errorToast = Toast.makeText(LoginActivity.this, "API Not Responding Check Connection", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }
                });

// Adding request to request queue
                AppController.getInstance().addToRequestQueue(jsonObjReq, "");
            }
        });



        }
}



