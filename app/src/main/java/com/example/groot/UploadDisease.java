package com.example.groot;

import static android.widget.Toast.*;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.groot.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UploadDisease extends AppCompatActivity implements View.OnClickListener {

    Button btn_select;
    Button btn_submit;

    ImageView img_prev;

    EditText tbx_disease;


    Uri imageUri;
    ActivityMainBinding binding;
    StorageReference storageReference;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upload_disease);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_select =findViewById(R.id.btn_select);
        btn_submit =findViewById(R.id.btn_submit);
        img_prev =findViewById(R.id.img_prev);

        tbx_disease = findViewById(R.id.tbx_disease);


        btn_select.setOnClickListener(this);
        btn_submit.setOnClickListener(this);

        ImageButton btn_mini_capture = findViewById(R.id.btn_mini_capture);
        ImageButton btn_mini_lib = findViewById(R.id.btn_mini_lib);
        ImageButton btn_mini_report = findViewById(R.id.btn_mini_report);


        btn_mini_capture.setOnClickListener(this);
        btn_mini_lib.setOnClickListener(this);
        btn_mini_report.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int ID = v.getId();

        if (ID == R.id.btn_mini_lib){
            Intent intent = new Intent(this,Library.class);
            startActivity(intent);
            finish();
            Log.i("BTN_CLICKED","Clicked miniLin");

        }else if (ID == R.id.btn_mini_capture) {
            Log.i("BTN_CLICKED","Clicked");
            Intent intent = new Intent(this,Capture.class);
            startActivity(intent);
            finish();

        } else if(ID == R.id.btn_mini_report){

        }

        if (ID == R.id.btn_select){
            selectImages();

        } else if (ID == R.id.btn_submit) {
            uploadImage();
            tbx_disease.setText(null);

        }


    }

    private void selectImages(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 100);


    }
    private  void uploadImage(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading File. . .");
        progressDialog.show();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.TAIWAN);
        Date now = new Date();
        String filename = tbx_disease.getText().toString()+"_"+formatter.format(now);

        storageReference = FirebaseStorage.getInstance().getReference("disease/"+filename);

        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        img_prev.setImageURI(null);
                        Toast.makeText(UploadDisease.this,"Success", LENGTH_SHORT).show();
                        if(progressDialog.isShowing()){
                            progressDialog.dismiss();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if(progressDialog.isShowing())
                            progressDialog.dismiss();

                        Toast.makeText(UploadDisease.this,"Failed to Upload", LENGTH_SHORT).show();

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && data.getData()!=null){
            imageUri = data.getData();
            img_prev = findViewById(R.id.img_prev);
            img_prev.setImageURI(imageUri);
        }
    }
}