package com.example.groot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
                    ImageButton imageButton = new ImageButton(this);
                    imageButton.setLayoutParams(new LinearLayout.LayoutParams(
                            350, // width
                            350)); // height
                    imageButton.setImageResource(R.drawable.tree_svgrepo_com);
                    imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageButton.getLayoutParams();
                    params.setMargins(0, 0, 30, 0); // left, top, right, bottom
                    imageButton.setLayoutParams(params);


//                ImageButton imageButton = new ImageButton(this);
//                imageButton.setLayoutParams(new LinearLayout.LayoutParams(
//                        350, // width
//                        350)); // height
//                imageButton.setImageResource(R.drawable.tree_svgrepo_com);
//                imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageButton.getLayoutParams();
//                params.setMargins(0, 0, 30, 0); // left, top, right, bottom
//                imageButton.setLayoutParams(params);
//
//                String uniqueId = DatabaseHelper.Common_Name;
//
//                int resourceId = getResources().getIdentifier(uniqueId, "id", getPackageName());
//                imageButton.setId(resourceId);


//                Button button = new Button(this);
//                button.setText("Button " + commonName+"_"+x);
//               button.setLayoutParams(new LinearLayout.LayoutParams(
//                        350, // width
//                        350)); // height
//                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
//                params.setMargins(0, 0, 30, 0); // left, top, right, bottom
//                button.setLayoutParams(params);

                final int buttonIndex = x;
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Action to perform when any dynamically generated button is clicked
                        CM = commonName;
                        openInfo();
                        Toast.makeText(Library.this, commonName + buttonIndex + " clicked!", Toast.LENGTH_SHORT).show();
                    }
                });
                x++;


                linearLayout.addView(imageButton);

            }while (cursor.moveToNext());

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