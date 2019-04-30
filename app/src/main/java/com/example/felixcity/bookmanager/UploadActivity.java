package com.example.felixcity.bookmanager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadActivity extends AppCompatActivity {

    EditText EditPdfName;
    Button UploadButton;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        EditPdfName = findViewById(R.id.txtPdfName);
        UploadButton = findViewById(R.id.upload);

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");

        UploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPdfFile();
            }
        });
    }

    private void selectPdfFile()
    {
        Intent intent = new Intent();
        intent.setType("appliction/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF "),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== 1 && resultCode== RESULT_OK && data !=null && data.getData() !=null)
        {
            uploadPDF(data.getData());
        }
    }

    private void uploadPDF(Uri data)
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Uploading....");
        progressDialog.show();

        StorageReference reference = storageReference.child("uploads/"+System.currentTimeMillis()+"pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri>uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete());
                        Uri Url = uri.getResult();

                        upLoadPdf upLoadPdf = new upLoadPdf(EditPdfName.getText().toString(),Url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(upLoadPdf);
                        Toast.makeText(UploadActivity.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                      double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                       progressDialog.setMessage("Upload : "+(int)progress+"%");
                    }
                });
    }
}
