package com.example.groot;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DiseaseInfo extends AppCompatActivity implements View.OnClickListener {
    DatabaseManager db;

    TextView txt_name;
    TextView txt_symptoms;
    TextView txt_agent;
    TextView txt_host;
    TextView txt_management;
    TextView txt_cultural;
    TextView txt_chemical;

    ImageView img_disease;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_disease_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = new DatabaseManager(this);
        try {
            db.open();
        } catch (Exception e) {
            e.printStackTrace();
        }


         txt_name = findViewById(R.id.txt_name);
         txt_symptoms = findViewById(R.id.txt_symptoms);
         txt_agent = findViewById(R.id.txt_agent);
         txt_host = findViewById(R.id.txt_host);
         txt_management = findViewById(R.id.txt_management);
         txt_cultural = findViewById(R.id.txt_cultural);
         txt_chemical = findViewById(R.id.txt_chemical);

        ImageButton btn_mini_capture = findViewById(R.id.btn_mini_capture);
        ImageButton btn_mini_upload = findViewById(R.id.btn_mini_upload);
        ImageButton btn_mini_report = findViewById(R.id.btn_mini_report);


        btn_mini_capture.setOnClickListener(this);
        btn_mini_upload.setOnClickListener(this);
        btn_mini_report.setOnClickListener(this);



        ImageView img_disease = findViewById(R.id.img_disease);

        Cursor cursor = db.DISEASE_fetch(DatabaseHelper.DISEASE_NAME + " = ?",new String[]{Library.CM});

        if(cursor.moveToFirst()){
            do{
                String diseaseName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.DISEASE_NAME));
                String symptoms = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.DISEASE_SYMPTOMS));
                String  agent = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.DISEASE_AGENT));
                String host = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.DISEASE_HOST));
                String  management = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.DISEASE_Management));
                String cultural = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.DISEASE_Cultural_Control));
                String chemical = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.DISEASE_Chemical_Control));
                String Images = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Images));

                txt_name.setText(diseaseName);
                txt_symptoms.setText(symptoms);
                txt_agent.setText(agent);
                txt_host.setText(host);
                txt_management.setText(management);
                txt_cultural.setText(cultural);
                txt_chemical.setText(chemical);

                int xxxx = Integer.parseInt(Images);


                Uri path = Uri.parse("android.resource://com.example.groot/" + xxxx);
//                   img_tree.setImageDrawable(path);
                img_disease.setImageURI(path);

            }while (cursor.moveToNext());
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