package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UploadBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_books);

        Button Upload = findViewById(R.id.upload_btn);
        Button Download = findViewById(R.id.download_btn);


        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadBooksActivity.this,UploadActivity.class);
                startActivity(intent);
            }
        });

        Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadBooksActivity.this,DownloadActivity.class);
                startActivity(intent);
            }
        });

    }
}
