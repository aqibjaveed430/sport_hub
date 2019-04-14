package com.tritechteal.sport_hub.OraganizeTournament;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.tritechteal.sport_hub.CurrentPreviousTournament;
import com.tritechteal.sport_hub.Dashboard;
import com.tritechteal.sport_hub.R;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends AppCompatActivity {
Spinner selct_trmnt_sport;
Button tournament_reg_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        tournament_reg_btn = (Button) findViewById(R.id.add_tournament_btn);
        tournament_reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Tournament.this, CurrentPreviousTournament.class);
                startActivity(intent);
            }
        });

        selct_trmnt_sport = (Spinner) findViewById(R.id.slct_trmnt_sport);

        List<String> selct_tournt_type=new ArrayList<String>();
        selct_tournt_type.add("Select Sport");
        selct_tournt_type.add("Cricket");
        selct_tournt_type.add("football");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,selct_tournt_type);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selct_trmnt_sport.setAdapter(arrayAdapter);


        selct_trmnt_sport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                selct_trmnt_sport.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });
    }
}
