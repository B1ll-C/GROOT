package com.example.groot;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLDataException;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context ctx){
        context = ctx;
    }

    public DatabaseManager open() throws SQLDataException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;

    }

    public void close(){
        dbHelper.close();
    }
    public void insert(long _id, String Common_Name, String Scientific_Name, String Description, String Location, String Contemporary_User, String Physical_Characteristics, String Care, String Pests){
        ContentValues contentValues = new ContentValues();
//        Column Names and Values
        contentValues.put(DatabaseHelper.TREE_ID,_id);
        contentValues.put(DatabaseHelper.Scientific_Name, Scientific_Name);
        contentValues.put(DatabaseHelper.Common_Name, Common_Name);
        contentValues.put(DatabaseHelper.Description, Description);
        contentValues.put(DatabaseHelper.Location, Location);
        contentValues.put(DatabaseHelper.Contemporary_Use, Contemporary_User);
        contentValues.put(DatabaseHelper.Physical_Characteristics, Physical_Characteristics);
        contentValues.put(DatabaseHelper.Care, Care);
        contentValues.put(DatabaseHelper.Pests, Pests);

        database.insert(DatabaseHelper.DATABASE_TABLE, null, contentValues);
        Log.i("Insert_Success","Nice One");
    }

    public Cursor fetch(String conditions, String[] args){
        String [] columns = new String[] {
                DatabaseHelper.Common_Name,
                DatabaseHelper.Scientific_Name,
                DatabaseHelper.Description,
                DatabaseHelper.Location,
                DatabaseHelper.Contemporary_Use,
                DatabaseHelper.Physical_Characteristics,
                DatabaseHelper.Care,
                DatabaseHelper.Pests};

        if (conditions==null)
            conditions="";

        Cursor cursor = database.query(DatabaseHelper.DATABASE_TABLE, columns, conditions,args,null,null,null);
        if(cursor!= null){
            cursor.moveToFirst();
        }
        return cursor;
    }


    public int update(long _id, String Common_Name, String Scientific_Name, String Description, String Location, String Contemporary_User, String Physical_Characteristics, String Care, String Pests){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.Scientific_Name, Scientific_Name);
        contentValues.put(DatabaseHelper.Common_Name, Common_Name);
        contentValues.put(DatabaseHelper.Description, Description);
        contentValues.put(DatabaseHelper.Location, Location);
        contentValues.put(DatabaseHelper.Contemporary_Use, Contemporary_User);
        contentValues.put(DatabaseHelper.Physical_Characteristics, Physical_Characteristics);
        contentValues.put(DatabaseHelper.Care, Care);
        contentValues.put(DatabaseHelper.Pests, Pests);
        database.insert(DatabaseHelper.DATABASE_TABLE, null, contentValues);
        int ret = database.update(DatabaseHelper.DATABASE_TABLE,contentValues,DatabaseHelper.TREE_ID+"="+_id,null);
        return ret;

    }

    public void delete(long _id){
        database.delete(DatabaseHelper.DATABASE_TABLE,DatabaseHelper.TREE_ID+"="+_id,null);

    }




}

