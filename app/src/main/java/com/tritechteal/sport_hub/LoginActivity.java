package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.tritechteal.sport_hub.MainHome.Dashboard;

public class LoginActivity extends AppCompatActivity {
    EditText user_email;
    EditText user_password;
    CheckBox remember_me;
    TextView forget_password;
    Button sign_button;
    Button sign_up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}



