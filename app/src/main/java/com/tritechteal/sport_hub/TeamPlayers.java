package com.tritechteal.sport_hub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TeamPlayers extends AppCompatActivity {
    Spinner player_role1;
    Spinner player_role2;
    Spinner player_role3;
    Spinner player_role4;
    Spinner player_role5;
    Spinner player_role6;
    Spinner player_role7;
    Spinner player_role8;
    Spinner player_role9;
    Spinner player_role10;
    Spinner player_role11;
    Spinner player_role12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_players);

        // Player ONE Spinner

        player_role1 = (Spinner) findViewById(R.id.team_player_role1);

        List<String> player_role_list=new ArrayList<String>();
        player_role_list.add("Select Role");
        player_role_list.add("Batsman");
        player_role_list.add("Bowler");
        player_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player_role_list);
        role_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role1.setAdapter(role_arrayAdapter);


        player_role1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role1.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player TWO Spinner

        player_role2 = (Spinner) findViewById(R.id.team_player_role2);

        List<String> player2_role_list=new ArrayList<String>();
        player2_role_list.add("Select Role");
        player2_role_list.add("Batsman");
        player2_role_list.add("Bowler");
        player2_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role1_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player2_role_list);
        role_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role2.setAdapter(role1_arrayAdapter);


        player_role2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role2.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player THREE Spinner

        player_role3 = (Spinner) findViewById(R.id.team_player_role3);

        List<String> player3_role_list=new ArrayList<String>();
        player3_role_list.add("Select Role");
        player3_role_list.add("Batsman");
        player3_role_list.add("Bowler");
        player3_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role3_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player3_role_list);
        role3_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role3.setAdapter(role3_arrayAdapter);


        player_role3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role3.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player THREE Spinner

        player_role4 = (Spinner) findViewById(R.id.team_player_role4);

        List<String> player4_role_list=new ArrayList<String>();
        player4_role_list.add("Select Role");
        player4_role_list.add("Batsman");
        player4_role_list.add("Bowler");
        player4_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role4_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player4_role_list);
        role4_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role4.setAdapter(role4_arrayAdapter);


        player_role4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role4.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });


        // Player FIVE Spinner

        player_role5 = (Spinner) findViewById(R.id.team_player_role5);

        List<String> player5_role_list=new ArrayList<String>();
        player5_role_list.add("Select Role");
        player5_role_list.add("Batsman");
        player5_role_list.add("Bowler");
        player5_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role5_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player5_role_list);
        role5_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role5.setAdapter(role5_arrayAdapter);


        player_role5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role5.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player SIX Spinner

        player_role6 = (Spinner) findViewById(R.id.team_player_role6);

        List<String> player6_role_list=new ArrayList<String>();
        player6_role_list.add("Select Role");
        player6_role_list.add("Batsman");
        player6_role_list.add("Bowler");
        player6_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role6_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player6_role_list);
        role6_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role6.setAdapter(role6_arrayAdapter);


        player_role6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role6.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });


        // Player SEVEN Spinner

        player_role7 = (Spinner) findViewById(R.id.team_player_role7);

        List<String> player7_role_list=new ArrayList<String>();
        player7_role_list.add("Select Role");
        player7_role_list.add("Batsman");
        player7_role_list.add("Bowler");
        player7_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role7_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player7_role_list);
        role7_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role7.setAdapter(role7_arrayAdapter);


        player_role7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role7.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player EIGHT Spinner

        player_role8 = (Spinner) findViewById(R.id.team_player_role8);

        List<String> player8_role_list=new ArrayList<String>();
        player8_role_list.add("Select Role");
        player8_role_list.add("Batsman");
        player8_role_list.add("Bowler");
        player8_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role8_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player8_role_list);
        role8_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role8.setAdapter(role8_arrayAdapter);


        player_role8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role8.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player NINE Spinner


        player_role9 = (Spinner) findViewById(R.id.team_player_role9);

        List<String> player9_role_list=new ArrayList<String>();
        player9_role_list.add("Select Role");
        player9_role_list.add("Batsman");
        player9_role_list.add("Bowler");
        player9_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role9_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player9_role_list);
        role9_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role9.setAdapter(role9_arrayAdapter);


        player_role9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role9.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player TEN Spinner

        player_role10 = (Spinner) findViewById(R.id.team_player_role10);

        List<String> player10_role_list=new ArrayList<String>();
        player10_role_list.add("Select Role");
        player10_role_list.add("Batsman");
        player10_role_list.add("Bowler");
        player10_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role10_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player10_role_list);
        role10_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role10.setAdapter(role10_arrayAdapter);


        player_role10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role10.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

        // Player ELEVEN Spinner

        player_role11 = (Spinner) findViewById(R.id.team_player_role11);

        List<String> player11_role_list=new ArrayList<String>();
        player11_role_list.add("Select Role");
        player11_role_list.add("Batsman");
        player11_role_list.add("Bowler");
        player11_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role11_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player11_role_list);
        role11_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role11.setAdapter(role11_arrayAdapter);


        player_role11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role11.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });


        // Player TWELVE Spinner


        player_role12 = (Spinner) findViewById(R.id.team_player_role12);

        List<String> player12_role_list=new ArrayList<String>();
        player12_role_list.add("Select Role");
        player12_role_list.add("Batsman");
        player12_role_list.add("Bowler");
        player12_role_list.add("Wicket Keeper");

        ArrayAdapter<String> role12_arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,player12_role_list);
        role12_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        player_role12.setAdapter(role12_arrayAdapter);


        player_role12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                player_role12.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });

    }
}
