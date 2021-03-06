package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {
    private ImageView organize_team;
    private ImageView needed_player;
    private ImageView organize_tournament;
    private ImageView analyze_statistics;
    private ImageView share_photo;
    private ImageView tournamenmt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Button Code
        organize_team = (ImageView) findViewById(R.id.team);
        organize_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this, RegisterTeam.class);
                startActivity(intent);
            }
        });


        needed_player = (ImageView) findViewById(R.id.needed_player);
        needed_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this, NeededPlayer.class);
                startActivity(intent);
            }
        });

        organize_tournament = (ImageView) findViewById(R.id.organize);
        organize_tournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this, Tournament.class);
                startActivity(intent);
            }
        });

        analyze_statistics = (ImageView) findViewById(R.id.analyze_statistics);
        analyze_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this, DisplayTeam.class);
                startActivity(intent);
            }
        });


        share_photo = (ImageView) findViewById(R.id.photos);
        share_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this, UploadPhoto.class);
                startActivity(intent);
            }
        });

        tournamenmt = (ImageView) findViewById(R.id.tournament);
        tournamenmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this, CurrentPreviousTournament.class);
                startActivity(intent);
            }
        });

    }


}

