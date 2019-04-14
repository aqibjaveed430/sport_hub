package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tritechteal.sport_hub.LoginActivity;
import com.tritechteal.sport_hub.OraganizeTournament.OrganizeTournament;
import com.tritechteal.sport_hub.OraganizeTournament.Tournament;
import com.tritechteal.sport_hub.R;
import com.tritechteal.sport_hub.Signup;

public class Dashboard extends AppCompatActivity {
    private ImageView organize_tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Button Code
        organize_tournament = (ImageView) findViewById(R.id.organize);
        organize_tournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this, Tournament.class);
                startActivity(intent);
            }
        });


    }


}

