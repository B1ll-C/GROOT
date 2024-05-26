package com.example.groot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Upload extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upload);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
    }
}