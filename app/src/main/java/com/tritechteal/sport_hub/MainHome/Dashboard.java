package com.tritechteal.sport_hub.MainHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tritechteal.sport_hub.LoginActivity;
import com.tritechteal.sport_hub.OraganizeTournament.OrganizeTournament;
import com.tritechteal.sport_hub.R;
import com.tritechteal.sport_hub.Signup;

public class Dashboard extends AppCompatActivity {
private Button organize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        organize=(Button) findViewById(R.id.signin);
        organize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrganizeTournament();

            }
        });


        //button1

//button



       // organize=(Button) findViewById(R.id.signup1);
        organize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrganizeTournament();
            }
        });
    }
    public void organize(){
        Intent intent =new Intent(this, OrganizeTournament.class);
        startActivity(intent);
    }
    public void OrganizeTournament (){
        Intent intent=new Intent(this, OrganizeTournament.class);
        startActivity(intent);

    }


}

