package com.tritechteal.sport_hub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CurrentPreviousTournament extends AppCompatActivity {
    public static ArrayList<String> TournamentName = new ArrayList<>();
    public static ArrayList<String> TournamentDetial = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_previous_tournament);
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.act_recyclerview3);

        TournamentName.add("Abasyn Cricket Tournament");
        TournamentName.add("Abasyn Football Tournament");




        TournamentDetial.add("Chak Shazad");
        TournamentDetial.add("Stadium");
        TournamentDetial.add("Rawalapindi");
        TournamentDetial.add("Farash");
        TournamentDetial.add("Alipur");
        TournamentDetial.add("Tramri");
        TournamentDetial.add("Isamabad");
        TournamentDetial.add("Rawalpindi");
        TournamentDetial.add("Alipur");

        DataAdapter mDataAdapter = new DataAdapter(CurrentPreviousTournament.this, TournamentName , TournamentDetial);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mDataAdapter);


    }
}
