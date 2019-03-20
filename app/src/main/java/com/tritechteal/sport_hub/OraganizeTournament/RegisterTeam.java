package com.tritechteal.sport_hub.OraganizeTournament;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tritechteal.sport_hub.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterTeam extends AppCompatActivity {
Spinner select_team_sport;
Spinner selct_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_team);

        select_team_sport = (Spinner) findViewById(R.id.select_sport);

        List<String> select_sport_list=new ArrayList<String>();
        select_sport_list.add("Select Sport");
        select_sport_list.add("Cricket");
        select_sport_list.add("football");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select_sport_list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_team_sport.setAdapter(arrayAdapter);


        select_team_sport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                select_team_sport.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        selct_city = (Spinner) findViewById(R.id.selec_tcity);

        List<String> select_area_list=new ArrayList<String>();
        select_area_list.add("Select Sport");
        select_area_list.add("Cricket");
        select_area_list.add("football");

        ArrayAdapter<String> arrayAdapter_area=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select_area_list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selct_city.setAdapter(arrayAdapter_area);


        selct_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                selct_city.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });
    }
}
