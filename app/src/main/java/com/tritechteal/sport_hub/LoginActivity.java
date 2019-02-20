package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tritechteal.sport_hub.MainHome.Dashboard;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.signin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dashboard();

            }
        });


        //button1

//button



        button=(Button) findViewById(R.id.signup1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });
    }
    public void Signup(){
        Intent intent =new Intent(this,Signup.class);
        startActivity(intent);

    }
    public void dashboard(){
        Intent intent=new Intent(this,Dashboard.class);
        startActivity(intent);

    }
}
