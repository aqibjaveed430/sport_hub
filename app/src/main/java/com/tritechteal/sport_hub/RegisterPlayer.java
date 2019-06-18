package com.tritechteal.sport_hub;

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
    Spinner selecttype;
    Spinner selec_player_city;
    Spinner select_player_area;



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

        selecttype = (Spinner) findViewById(R.id.select_type);

        List<String> list_player_type=new ArrayList<String>();
        list_player_type.add("Select Type");
        list_player_type.add("Batsman");
        list_player_type.add("Bowler");

        ArrayAdapter<String> arrayAdapter_player_type=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_player_type);
        arrayAdapter_player_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecttype.setAdapter(arrayAdapter_player_type);


        selecttype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                selecttype.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        selec_player_city = (Spinner) findViewById(R.id.select_player_city);

        List<String> list_player_city=new ArrayList<String>();
        list_player_city.add("Select City");
        list_player_city.add("Islamabad");
        list_player_city.add("Rawakpindi");

        ArrayAdapter<String> arrayAdapter_player_city=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_player_city);
        arrayAdapter_player_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selec_player_city.setAdapter(arrayAdapter_player_city);


        selec_player_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                selec_player_city.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        select_player_area = (Spinner) findViewById(R.id.select_player_area);

        List<String> list_player_area=new ArrayList<String>();
        list_player_area.add("Select Area");
        list_player_area.add("Chak Shazad");
        list_player_area.add("Sadiqabad");

        ArrayAdapter<String> arrayAdapter_player_area=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list_player_area);
        arrayAdapter_player_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_player_area.setAdapter(arrayAdapter_player_area);


        select_player_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                select_player_area.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });
    }
}
