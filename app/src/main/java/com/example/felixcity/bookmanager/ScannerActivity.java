package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScannerActivity extends AppCompatActivity {

    private Button ScanBtn;
    public static TextView scanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        ScanBtn = findViewById(R.id.scan_btn);
        scanResult = findViewById(R.id.scan_result);

        ScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScanner = new Intent(getApplicationContext(),ScanResultActivity.class);
                startActivity(intentScanner);
            }
        });
    }
}
