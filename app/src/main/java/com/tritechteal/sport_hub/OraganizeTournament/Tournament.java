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

public class Tournament extends AppCompatActivity {
Spinner selct_trmnt_sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

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
