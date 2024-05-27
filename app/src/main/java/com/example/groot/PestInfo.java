package com.example.groot;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PestInfo extends AppCompatActivity implements View.OnClickListener{

    DatabaseManager db;

    TextView txt_common_name;
    TextView txt_scientific_name;
    TextView txt_family;
    TextView txt_description;
    TextView txt_host_range;
    TextView txt_damage;
    TextView txt_management;

    ImageView img_pest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pest_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_common_name = findViewById(R.id.txt_common_name);
        txt_scientific_name = findViewById(R.id.txt_scientific_name);
        txt_family = findViewById(R.id.txt_family);
        txt_description = findViewById(R.id.txt_description);
        txt_host_range = findViewById(R.id.txt_host_range);
        txt_damage = findViewById(R.id.txt_damage);
        txt_management = findViewById(R.id.txt_mangement);
        img_pest = findViewById(R.id.img_pest);



        ImageButton btn_mini_capture = findViewById(R.id.btn_mini_capture);
        ImageButton btn_mini_upload = findViewById(R.id.btn_mini_upload);
        ImageButton btn_mini_report = findViewById(R.id.btn_mini_report);


        btn_mini_capture.setOnClickListener(this);
        btn_mini_upload.setOnClickListener(this);
        btn_mini_report.setOnClickListener(this);

        db = new DatabaseManager(this);
        try {
            db.open();
        }catch (Exception e){
            e.printStackTrace();
        }

        Cursor pests = db.PEST_fetch(DatabaseHelper.PEST_Common_Name+" = ?",new String[]{Library.CM});
//
        if(pests.moveToFirst()) {
            int x = 1;

            do {
                String pest_commonName = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.PEST_Common_Name));
                String pest_scientificName = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.PEST_Scientific_Name));
                String pest_family = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.PEST_family));
                String pest_description = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.PEST_Description));
                String pest_host = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.Pests_Host_Range));
                String pest_damage = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.PEST_Damage));
                String pest_management = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.PEST_Management));
                String Images = pests.getString(pests.getColumnIndexOrThrow(DatabaseHelper.PEST_Images));
//////
////                    Log.i("Database_TAG","I have read ID : " + ID + " Username: "+username+" password: "+password);
//                Log.i("Database_TAG", "ID: " + treeId + "\n");

                StringBuilder pestInfo = new StringBuilder();
                pestInfo.append("Common Name: ").append(pest_commonName).append("\n");
                pestInfo.append("Scientific Name: ").append(pest_scientificName).append("\n");
                pestInfo.append("Family: ").append(pest_family).append("\n");
                pestInfo.append("Description: ").append(pest_description).append("\n");
                pestInfo.append("Host Range: ").append(pest_host).append("\n");
                pestInfo.append("Damage: ").append(pest_damage).append("\n");
                pestInfo.append("Management: ").append(pest_management).append("\n");

                String message = pestInfo.toString();
                Log.i("PEST_INFO", message);



                txt_common_name.setText(pest_commonName);
                txt_scientific_name.setText(pest_scientificName);
                txt_family.setText(pest_family);
                txt_description.setText(pest_description);
                txt_host_range.setText(pest_host);
                txt_damage.setText(pest_damage);
                txt_management.setText(pest_management);

                int xxxx = Integer.parseInt(Images);
                Uri path = Uri.parse("android.resource://com.example.groot/" + xxxx);

                img_pest.setImageURI(path);
            }while(pests.moveToNext());
        }

    }

    @Override
    public void onClick(View v) {
        int ID = v.getId();

        if (ID == R.id.btn_mini_capture){
            Intent intent = new Intent(this,Capture.class);
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