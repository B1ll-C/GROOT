package com.example.groot;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "GROOT";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_TABLE = "TREE";
//    table column name
    static final String TREE_ID = "TREE_ID";
    static final String Common_Name = "Common_Name";
    static final String Scientific_Name = "Scientific_Name";
    static final String Description = "Description";
    static final String Location = "Location";
    static final String Contemporary_Use = "Contemporary_Use";
    static final String Physical_Characteristics = "Physical_Characteristics";
    static final String Care = "Care";
    static final String Pests = "Pests";

    private static final String CREATE_DB_QUERY = "CREATE TABLE " + DATABASE_TABLE + " (" +
            TREE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            Common_Name + " TEXT NOT NULL, " +
            Scientific_Name + " TEXT NOT NULL, " +
            Description + " TEXT, " +
            Location + " TEXT, " +
            Contemporary_Use + " TEXT, " +
            Physical_Characteristics + " TEXT, " +
            Care + " TEXT, " +
            Pests + " TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE);
    }
}
