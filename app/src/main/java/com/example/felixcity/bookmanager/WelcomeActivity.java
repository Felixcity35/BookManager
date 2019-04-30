package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
  private Button Login,SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        Login = findViewById(R.id.login);
        SignUp = findViewById(R.id.signup);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(login);
            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignUp = new Intent(WelcomeActivity.this,RegisterActivity.class);
                startActivity(SignUp);
            }
        });
    }
}
