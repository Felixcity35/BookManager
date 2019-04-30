package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QrCodeActivity extends AppCompatActivity {

    private Button barcode ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        barcode = findViewById(R.id.barcode);

        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(QrCodeActivity.this,ScannerActivity.class);
                startActivity(loginIntent);
            }
        });

    }
}
