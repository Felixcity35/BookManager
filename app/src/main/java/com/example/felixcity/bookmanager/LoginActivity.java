package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText Email,Password ;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);

        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(LoginActivity.this,TermsAndConditionActivity.class);
                startActivity(loginIntent);
            }
        });

    }
}
