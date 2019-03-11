package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tritechteal.sport_hub.MainHome.Dashboard;

public class Signup extends AppCompatActivity {
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerSignUp();
            }
        });
    }

    public void PlayerSignUp() {
        Intent intent = new Intent(this, PlayerSignUp.class);
        startActivity(intent);
    }
}
