package com.tritechteal.sport_hub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetPassword extends AppCompatActivity {
    private Button forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forget = (Button) findViewById(R.id.forget_sendbtn);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ForgetPassword.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
