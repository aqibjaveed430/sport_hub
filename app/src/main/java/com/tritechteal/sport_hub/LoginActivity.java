package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tritechteal.sport_hub.MainHome.Dashboard;

public class LoginActivity extends AppCompatActivity {
    private Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin = (Button) findViewById(R.id.button);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDasboard();
            }
        });
    }
public void openDasboard(){
        Intent intent= new Intent(this,Dashboard.class);
}

    }


