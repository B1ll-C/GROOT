package com.example.groot;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Capture extends AppCompatActivity implements View.OnClickListener {

    private static final int cameraRequest = 1888;
    private ImageView imageView;
    
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


        btn_mini_lib.setOnClickListener(this);
        btn_mini_upload.setOnClickListener(this);
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

        }else if (ID == R.id.btn_mini_upload) {
            Log.i("BTN_CLICKED","Clicked");
            Intent intent = new Intent(this,Upload.class);
            startActivity(intent);
            finish();

        } else if(ID == R.id.btn_mini_report){

        }
    }
}