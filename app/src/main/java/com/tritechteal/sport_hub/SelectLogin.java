package com.tritechteal.sport_hub;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectLogin extends AppCompatActivity {
Button organizer;
Button team;
Button player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login);

        player = (Button) findViewById(R.id.playerbtn);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectLogin.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        team = (Button) findViewById(R.id.teambtn);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectLogin.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        organizer = (Button) findViewById(R.id.organizerbtn);
        organizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectLogin.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
