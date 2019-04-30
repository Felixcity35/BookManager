package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanResultActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView scannerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) {
        String scan = result.getText();

        ScannerActivity.scanResult.setText(scan);

        String confirm ="ISBN-312-1-1145-5553-3";

        if( confirm.equalsIgnoreCase(scan))
        {
            Intent intent = new Intent(getApplicationContext(),GenuineActivity.class);
            startActivity(intent);

        }
        else {
            Intent fakeintent = new Intent(getApplicationContext(), FakeActivity.class);
            startActivity(fakeintent);
        }
        onBackPressed();

    }

    @Override
    protected void onPause() {
        super.onPause();

        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
