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

public class RegisterPlayer extends AppCompatActivity {
    Spinner selectsport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_player);


        selectsport = (Spinner) findViewById(R.id.slectsport);

        List<String> list=new ArrayList<String>();
        list.add("Select Sport");
        list.add("Cricket");
        list.add("football");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectsport.setAdapter(arrayAdapter);


        selectsport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                selectsport.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });
    }
}
