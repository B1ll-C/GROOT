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
    public void insert(long _id, String Common_Name, String Scientific_Name, String Description, String Location, String Contemporary_User, String Physical_Characteristics, String Care, String Pests,String Images){
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
//        String xxx = String.valueOf(R.drawable.bug_svgrepo_com);
        contentValues.put(DatabaseHelper.Images,Images);

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
                DatabaseHelper.Pests,
                DatabaseHelper.Images};

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


    public void PEST_insert(long _id, String Common_Name, String Scientific_Name, String Description, String family, String Host_Range, String Damage, String Management,String Images){
        ContentValues contentValues = new ContentValues();
//        Column Names and Values
        contentValues.put(DatabaseHelper.PEST_ID,_id);
        contentValues.put(DatabaseHelper.PEST_Scientific_Name, Scientific_Name);
        contentValues.put(DatabaseHelper.PEST_Common_Name, Common_Name);
        contentValues.put(DatabaseHelper.PEST_family, family);
        contentValues.put(DatabaseHelper.PEST_Description, Description);
        contentValues.put(DatabaseHelper.Pests_Host_Range, Host_Range);
        contentValues.put(DatabaseHelper.PEST_Damage, Damage);
        contentValues.put(DatabaseHelper.PEST_Management, Management);
        contentValues.put(DatabaseHelper.PEST_Images,Images);

        database.insert(DatabaseHelper.DATABASE_TABLE_PEST, null, contentValues);
        Log.i("Insert_Success","Nice One");
    }

    public Cursor PEST_fetch(String conditions, String[] args){
        String [] columns = new String[] {
                DatabaseHelper.PEST_Common_Name,
                DatabaseHelper.PEST_Scientific_Name,
                DatabaseHelper.PEST_family,
                DatabaseHelper.PEST_Description,
                DatabaseHelper.Pests_Host_Range,
                DatabaseHelper.PEST_Damage,
                DatabaseHelper.PEST_Management,
                DatabaseHelper.Images};

        if (conditions==null)
            conditions="";

        Cursor cursor = database.query(DatabaseHelper.DATABASE_TABLE_PEST, columns, conditions,args,null,null,null);
        if(cursor!= null){
            cursor.moveToFirst();
        }
        return cursor;
    }

//    DISEASE

    public void DISEASE_insert(long _id, String Name, String Symptoms, String Agent, String Host, String Management, String Cultural_Control, String Chemical_Control,String Images){
        ContentValues contentValues = new ContentValues();
//        Column Names and Values
        contentValues.put(DatabaseHelper.DISEASE_ID,_id);
        contentValues.put(DatabaseHelper.DISEASE_NAME, Name);
        contentValues.put(DatabaseHelper.DISEASE_SYMPTOMS, Symptoms);
        contentValues.put(DatabaseHelper.DISEASE_AGENT, Agent);
        contentValues.put(DatabaseHelper.DISEASE_HOST, Host);
        contentValues.put(DatabaseHelper.DISEASE_Management, Management);
        contentValues.put(DatabaseHelper.DISEASE_Cultural_Control, Cultural_Control);
        contentValues.put(DatabaseHelper.DISEASE_Chemical_Control, Chemical_Control);
        contentValues.put(DatabaseHelper.DISEASE_Images,Images);

        database.insert(DatabaseHelper.DATABASE_TABLE_DISEASE, null, contentValues);
        Log.i("Insert_Success","Disease");
    }

    public Cursor DISEASE_fetch(String conditions, String[] args){
        String [] columns = new String[] {
                DatabaseHelper.DISEASE_NAME,
                DatabaseHelper.DISEASE_SYMPTOMS,
                DatabaseHelper.DISEASE_AGENT,
                DatabaseHelper.DISEASE_HOST,
                DatabaseHelper.DISEASE_Management,
                DatabaseHelper.DISEASE_Cultural_Control,
                DatabaseHelper.DISEASE_Chemical_Control,
                DatabaseHelper.DISEASE_Images};

        if (conditions==null)
            conditions="";

        Cursor cursor = database.query(DatabaseHelper.DATABASE_TABLE_DISEASE, columns, conditions,args,null,null,null);
        if(cursor!= null){
            cursor.moveToFirst();
        }

        Log.d("WOW","qrqwer");
        return cursor;
    }




}

