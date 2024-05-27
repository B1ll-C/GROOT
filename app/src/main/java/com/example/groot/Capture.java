package com.example.groot;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Capture extends AppCompatActivity implements View.OnClickListener {

    private static final int cameraRequest = 1888;
    private static ImageView img_capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_capture);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btn_mini_lib = findViewById(R.id.btn_mini_lib);
        ImageButton btn_mini_upload = findViewById(R.id.btn_mini_upload);
        ImageButton btn_mini_report = findViewById(R.id.btn_mini_report);

        img_capture = findViewById(R.id.img_capture);


        btn_mini_lib.setOnClickListener(this);
        btn_mini_upload.setOnClickListener(this);
        btn_mini_report.setOnClickListener(this);

        Button btn_capture = findViewById(R.id.btn_capture);
        btn_capture.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {
        int ID = v.getId();

        if(ID == R.id.btn_capture){
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, 4444);
        }

        if (ID == R.id.btn_mini_lib){
            Intent intent = new Intent(this,Library.class);
            startActivity(intent);
            finish();
            Log.i("BTN_CLICKED","Clicked miniLin");

        }else if (ID == R.id.btn_mini_upload) {
            Log.i("BTN_CLICKED","Clicked");
            Intent intent = new Intent(this,Upload.class);
            startActivity(intent);
            finish();

        } else if(ID == R.id.btn_mini_report){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==4444 && resultCode==RESULT_OK){

            Bitmap image = (Bitmap) data.getExtras().get("data");
//
            img_capture.setImageBitmap(image);

        }
    }
}