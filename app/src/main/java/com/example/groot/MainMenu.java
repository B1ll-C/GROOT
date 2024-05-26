package com.example.groot;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btn_capture_pressed(View view){
        Intent intent = new Intent(this,Capture.class);
        startActivity(intent);
    }

    public void btn_library_pressed(View view){
        Intent intent = new Intent(this,Library.class);
        startActivity(intent);
    }

    public void btn_upload_pressed(View view){
        Intent intent = new Intent(this,Upload.class);
        startActivity(intent);
    }

    public void btn_report_pressed(View view){

    }






}