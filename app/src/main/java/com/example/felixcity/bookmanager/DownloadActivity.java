package com.example.felixcity.bookmanager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DownloadActivity extends AppCompatActivity {
    DatabaseReference databaseReference ;
    List<upLoadPdf> upLoadPdfs ;

    ListView myPdfListView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        myPdfListView = findViewById(R.id.myListview);
        upLoadPdfs = new ArrayList<>();

        ViewAllFiles();

        myPdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                upLoadPdf upLoadPdf = upLoadPdfs.get(i);

                Intent intent = new Intent();
                intent.setData(Uri.parse(upLoadPdf.getUrl()));
                startActivity(intent);

            }
        });
    }

    private void ViewAllFiles()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for(DataSnapshot postsnapshot : dataSnapshot.getChildren()) {
                    upLoadPdf upLoadPdf = postsnapshot.getValue(com.example.felixcity.bookmanager.upLoadPdf.class);
                    upLoadPdfs.add(upLoadPdf);

                }

                String[] uploads = new String[upLoadPdfs.size()];

                for(int i=0;i<uploads.length; i++){

                    uploads[i] = upLoadPdfs.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);

                        TextView Text =(TextView) view.findViewById(android.R.id.text1);

                        Text.setTextColor(Color.BLACK);

                        return view;
                    }
                };





                myPdfListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
