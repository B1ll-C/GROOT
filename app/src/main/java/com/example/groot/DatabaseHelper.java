package com.example.groot;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "GROOT";
    static final int DATABASE_VERSION = 1;
    //    table  Tree
    static final String DATABASE_TABLE = "TREE";
    static final String TREE_ID = "TREE_ID";
    static final String Common_Name = "Common_Name";
    static final String Scientific_Name = "Scientific_Name";
    static final String Description = "Description";
    static final String Location = "Location";
    static final String Contemporary_Use = "Contemporary_Use";
    static final String Physical_Characteristics = "Physical_Characteristics";
    static final String Care = "Care";
    static final String Pests = "Pests";
    static final String Images = "Images";
//Pest
    static final String DATABASE_TABLE_PEST = "PEST";
    static final String PEST_ID = "PEST_ID";
    static final String PEST_Common_Name = "Common_Name";
    static final String PEST_Scientific_Name = "Scientific_Name";
    static final String PEST_family = "Family";
    static final String PEST_Description = "Description";
    static final String Pests_Host_Range = "Host_Range";
    static final String PEST_Damage = "Damage";
    static final String PEST_Management = "Management";
    static final String PEST_Images = "Images";


//    DISEASE
static final String DATABASE_TABLE_DISEASE = "DISEASE";
    static final String DISEASE_ID = "DISEASE_ID";
    static final String DISEASE_NAME = "Name";
    static final String DISEASE_SYMPTOMS = "Symptoms";
    static final String DISEASE_AGENT = "Agent";
    static final String DISEASE_HOST = "Host";
    static final String DISEASE_Management = "Management";
    static final String DISEASE_Cultural_Control = "Cultural_Control";
    static final String DISEASE_Chemical_Control = "Chemical_Control";
    static final String DISEASE_Images = "Images";

    private static final String PEST_CREATE_DB_QUERY = "CREATE TABLE " + DATABASE_TABLE_PEST + " (" +
            PEST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            PEST_Common_Name + " TEXT NOT NULL, " +
            PEST_Scientific_Name + " TEXT NOT NULL, " +
            PEST_family+" TEXT NOT NULL," +
            PEST_Description + " TEXT, " +
            Pests_Host_Range + " TEXT, " +
            PEST_Damage + " TEXT, " +
            PEST_Management + " TEXT, " +
            PEST_Images+" TEXT);";

    private static final String CREATE_DB_QUERY = "CREATE TABLE " + DATABASE_TABLE + " (" +
            TREE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            Common_Name + " TEXT NOT NULL, " +
            Scientific_Name + " TEXT NOT NULL, " +
            Description + " TEXT, " +
            Location + " TEXT, " +
            Contemporary_Use + " TEXT, " +
            Physical_Characteristics + " TEXT, " +
            Care + " TEXT, " +
            Pests + " TEXT," +
            Images+" TEXT);";

    private static final String DISEASE_CREATE_DB_QUERY = "CREATE TABLE " + DATABASE_TABLE_DISEASE + " (" +
            DISEASE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            DISEASE_NAME + " TEXT NOT NULL, " +
            DISEASE_SYMPTOMS + " TEXT NOT NULL, " +
            DISEASE_AGENT+" TEXT NOT NULL," +
            DISEASE_HOST + " TEXT, " +
            DISEASE_Management + " TEXT, " +
            DISEASE_Cultural_Control + " TEXT, " +
            DISEASE_Chemical_Control + " TEXT, " +
            DISEASE_Images+" TEXT );";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_QUERY);
        db.execSQL(PEST_CREATE_DB_QUERY);
        db.execSQL(DISEASE_CREATE_DB_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE_PEST);
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE_DISEASE);
    }
}
