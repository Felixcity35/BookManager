package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TermsAndConditionActivity extends AppCompatActivity {

    private Button Agreebtn,Disagreebtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);


        Agreebtn = findViewById(R.id.agree_btn);
        Disagreebtn = findViewById(R.id.disagree_btn);

        Agreebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agree = new Intent (TermsAndConditionActivity.this,MainActivity.class);
                startActivity(agree);
            }
        });

        Disagreebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent disagree = new Intent (TermsAndConditionActivity.this,WelcomeActivity.class);
                startActivity(disagree);
            }
        });
    }
}
