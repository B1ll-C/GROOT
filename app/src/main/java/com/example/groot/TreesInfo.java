package com.example.groot;

import android.annotation.SuppressLint;
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

public class TreesInfo extends AppCompatActivity implements View.OnClickListener {
    DatabaseManager db;

    TextView txt_common_name;
    TextView txt_scientific_name;
    TextView txt_description;
    TextView txt_location;
    TextView txt_contemporary_use;
    TextView txt_physical_characteristics;
    TextView txt_care;
    TextView txt_pests;

    ImageView img_tree;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trees_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_common_name = findViewById(R.id.txt_common_name);
        txt_scientific_name = findViewById(R.id.txt_scientific_name);
        txt_description = findViewById(R.id.txt_description);
        txt_location = findViewById(R.id.txt_location);
        txt_contemporary_use = findViewById(R.id.txt_contemporary_use);
        txt_physical_characteristics = findViewById(R.id.txt_physical_characterirstics);
        txt_care = findViewById(R.id.txt_care);
        txt_pests = findViewById(R.id.txt_pests);

        img_tree = findViewById(R.id.img_tree);



        ImageButton btn_mini_capture = findViewById(R.id.btn_mini_capture);
        ImageButton btn_mini_upload = findViewById(R.id.btn_mini_upload);
        ImageButton btn_mini_report = findViewById(R.id.btn_mini_report);


        btn_mini_capture.setOnClickListener(this);
        btn_mini_upload.setOnClickListener(this);
        btn_mini_report.setOnClickListener(this);




        db = new DatabaseManager(this);
        try {
            db.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cursor cursor = db.fetch(DatabaseHelper.Common_Name + " = ?",new String[]{Library.CM});


           if (cursor.moveToFirst()) {
               int x = 1;

               do {

                   String commonName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Common_Name));
                   String scientificName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Scientific_Name));
                   String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Description));
                   String location = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Location));
                   String contemporaryUse = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Contemporary_Use));
                   String physicalCharacteristics = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Physical_Characteristics));
                   String care = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Care));
                   String pests = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Pests));
                   String image = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.Images));

                   txt_common_name.setText(commonName);
                   txt_scientific_name.setText(scientificName);
                   txt_description.setText(description);
                   txt_location.setText(location);
                   txt_contemporary_use.setText(contemporaryUse);
                   txt_physical_characteristics.setText(physicalCharacteristics);
                   txt_care.setText(care);
                   txt_pests.setText(pests);

                   int xxxx = Integer.parseInt(image);


                   Uri path = Uri.parse("android.resource://com.example.groot/" + xxxx);
//                   img_tree.setImageDrawable(path);
                   img_tree.setImageURI(path);

////

                   Log.i("TREE_INFO", image);
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