package com.example.groot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;

public class Library extends AppCompatActivity implements View.OnClickListener {

    DatabaseManager db;
    public static String CM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_library);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


//        XMLToSQLiteImporter importer = new XMLToSQLiteImporter(this);
////        importer.importFromXML(R.raw.exported); // trees.xml should be in res/raw
//        importer.importFromXML(R.raw.exported);




        db = new DatabaseManager(this);
        try{
            db.open();
        } catch (Exception e){
            e.printStackTrace();
        }

//fetch code
        LinearLayout linearLayout = findViewById(R.id.hsv_tree);
        Cursor cursor = db.fetch(null,null);

        if(cursor.moveToFirst()){
            int x = 1;

            do{
//                String treeId = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.TREE_ID));

                  String commonName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Common_Name));
                    String scientificName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Scientific_Name));
                    String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Description));
                    String location = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Location));
                    String contemporaryUse = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Contemporary_Use));
                    String physicalCharacteristics = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Physical_Characteristics));
                    String care = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Care));
                String pests = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Pests));
                String Images = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Images));
////
////                    Log.i("Database_TAG","I have read ID : " + ID + " Username: "+username+" password: "+password);
//                Log.i("Database_TAG", "ID: " + treeId + "\n");

                Log.i("Database_TAG", "Common Name: " + commonName + "\n");
                    Log.i("Database_TAG", "Scientific Name: " + scientificName + "\n");
                    Log.i("Database_TAG", "Description: " + description + "\n");
                    Log.i("Database_TAG", "Location: " + location + "\n");
                    Log.i("Database_TAG", "Contemporary Use: " + contemporaryUse + "\n");
                    Log.i("Database_TAG", "Physical Characteristics: " + physicalCharacteristics + "\n");
                    Log.i("Database_TAG", "Care: " + care + "\n");
                Log.i("Database_TAG", "Pests: " + pests + "\n");
                Log.i("Database_TAG", "-----------END----------");

//                    Log.i("ColCount",xx);


                LinearLayout container = new LinearLayout(this); // Create the LinearLayout
                container.setOrientation(LinearLayout.VERTICAL);



                ImageButton imageButton = new ImageButton(this);
                imageButton.setLayoutParams(new LinearLayout.LayoutParams(
                300, // width
                300)); // height
                //                    imageButton.setImageResource(R.drawable.tree_svgrepo_com);
                int xxxx = Integer.parseInt(Images);
                Uri path = Uri.parse("android.resource://com.example.groot/" + xxxx);

                imageButton.setImageURI(path);
                imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
                container.addView(imageButton);

                TextView textView = new TextView(this);
                textView.setText(commonName); // Set the text
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                container.addView(textView);



                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageButton.getLayoutParams();
                params.setMargins(0, 0, 30, 0); // left, top, right, bottom
                imageButton.setLayoutParams(params);



                final int buttonIndex = x;
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Action to perform when any dynamically generated button is clicked
                        CM = commonName;
                        openInfo();
                        Toast.makeText(Library.this, commonName, Toast.LENGTH_SHORT).show();
                    }
                });
                x++;


                linearLayout.addView(container);

            }while (cursor.moveToNext());

        }
//    PEST
        Cursor pests = db.PEST_fetch(null,null);
        LinearLayout PEST_linearLayout = findViewById(R.id.hsv_pest);
//
        if(pests.moveToFirst()){
            int x = 0;
            do{
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

                LinearLayout container = new LinearLayout(this); // Create the LinearLayout
                container.setOrientation(LinearLayout.VERTICAL);



                ImageButton imageButton = new ImageButton(this);
                imageButton.setLayoutParams(new LinearLayout.LayoutParams(
                        300, // width
                        300)); // height
                //                    imageButton.setImageResource(R.drawable.tree_svgrepo_com);
                int xxxx = Integer.parseInt(Images);
                Uri path = Uri.parse("android.resource://com.example.groot/" + xxxx);

                imageButton.setImageURI(path);
                imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                container.addView(imageButton);

                TextView textView = new TextView(this);
                textView.setText(pest_commonName); // Set the text
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                container.addView(textView);



                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageButton.getLayoutParams();
                params.setMargins(0, 0, 30, 0); // left, top, right, bottom
                imageButton.setLayoutParams(params);



                final int buttonIndex = x;
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Action to perform when any dynamically generated button is clicked
                        CM = pest_commonName;
                        pest_openInfo();
                        Toast.makeText(Library.this, pest_commonName, Toast.LENGTH_SHORT).show();
                    }
                });
                x++;


                PEST_linearLayout.addView(container);




            } while(pests.moveToNext());
        }


//        Disease

        Cursor Disease = db.DISEASE_fetch(null,null);
        LinearLayout DISEASE_linearLayout = findViewById(R.id.hsv_disease);

        if (Disease.moveToFirst()){
            int x = 0;

            do {
                String diseaseName = Disease.getString(Disease.getColumnIndexOrThrow(DatabaseHelper.DISEASE_NAME));
                String  agent = Disease.getString(Disease.getColumnIndexOrThrow(DatabaseHelper.DISEASE_AGENT));
                String host = Disease.getString(Disease.getColumnIndexOrThrow(DatabaseHelper.DISEASE_HOST));
                String  management = Disease.getString(Disease.getColumnIndexOrThrow(DatabaseHelper.DISEASE_Management));
                String cultural = Disease.getString(Disease.getColumnIndexOrThrow(DatabaseHelper.DISEASE_Cultural_Control));
                String chemical = Disease.getString(Disease.getColumnIndexOrThrow(DatabaseHelper.DISEASE_Chemical_Control));
                String Images = Disease.getString(Disease.getColumnIndexOrThrow(DatabaseHelper.Images));
//
//                Log.i("DDDD", "Disease Information:");
//                Log.i("DDDD", "\tDisease Name: " + diseaseName);
//                Log.i("DDDD", "\tCausal Agent: " + agent);
//                Log.i("DDDD", "\tHost Plants: " + host);
//                Log.i("DDDD", "\tManagement Practices:\n\t\tCultural: " + cultural + "\n\t\tChemical: " + chemical);
//                Log.i("DDDD", "\tImage Path: " + Images);

                LinearLayout container = new LinearLayout(this); // Create the LinearLayout
                container.setOrientation(LinearLayout.VERTICAL);



                ImageButton imageButton = new ImageButton(this);
                imageButton.setLayoutParams(new LinearLayout.LayoutParams(
                        300, // width
                        300)); // height
                //                    imageButton.setImageResource(R.drawable.tree_svgrepo_com);
                int xxxx = Integer.parseInt(Images);
                Uri path = Uri.parse("android.resource://com.example.groot/" + xxxx);

                imageButton.setImageURI(path);
                imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                container.addView(imageButton);

                TextView textView = new TextView(this);
                textView.setText(diseaseName); // Set the text
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                container.addView(textView);



                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageButton.getLayoutParams();
                params.setMargins(0, 0, 30, 0); // left, top, right, bottom
                imageButton.setLayoutParams(params);



                final int buttonIndex = x;
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Action to perform when any dynamically generated button is clicked
                        CM = diseaseName;
                        disease_openInfo();
                        Toast.makeText(Library.this, diseaseName, Toast.LENGTH_SHORT).show();
                    }
                });
                x++;


                DISEASE_linearLayout.addView(container);

            }while (Disease.moveToNext());
        }




        ImageButton btn_mini_capture = findViewById(R.id.btn_mini_capture);
        ImageButton btn_mini_upload = findViewById(R.id.btn_mini_upload);
        ImageButton btn_mini_report = findViewById(R.id.btn_mini_report);


        btn_mini_capture.setOnClickListener(this);
        btn_mini_upload.setOnClickListener(this);
        btn_mini_report.setOnClickListener(this);
    }

    public void openInfo(){
        Intent intent = new Intent(this,TreesInfo.class);
        startActivity(intent);
//        finish();
    }

    public void pest_openInfo(){
        Intent intent = new Intent(this,PestInfo.class);
        startActivity(intent);
//        finish();
    }

    public void disease_openInfo(){
        Intent intent = new Intent(this,DiseaseInfo.class);
        startActivity(intent);
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