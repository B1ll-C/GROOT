package com.example.groot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;

public class XMLToSQLiteImporter {

    private Context context;
    private SQLiteDatabase db;

    public XMLToSQLiteImporter(Context context) {
        this.context = context;
        SQLiteOpenHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        Log.d("EXEC_IMPORT","IMPORTER");

    }

    public void importFromXML(int resourceId) {
        Log.d("EXEC_IMPORT","PARSE CALLED");

        try {
            @SuppressLint("ResourceType") XmlResourceParser parser = context.getResources().getXml(R.raw.exported);
            parser.next();
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && parser.getName().equals("tree")) {
                    String commonName = parser.getAttributeValue(null, "Common_Name");
                    String scientificName = parser.getAttributeValue(null, "Scientific_Name");
                    String description = parser.getAttributeValue(null, "Description");
                    String location = parser.getAttributeValue(null, "Location");
                    String contemporaryUse = parser.getAttributeValue(null, "Contemporary_Use");
                    String physicalCharacteristics = parser.getAttributeValue(null, "Physical_Characteristics");
                    String care = parser.getAttributeValue(null, "Care");
                    String pests = parser.getAttributeValue(null, "Pests");

                    insertTree(commonName, scientificName, description, location, contemporaryUse, physicalCharacteristics, care, pests);
                }
                eventType = parser.next();
                Log.d("EXEC_IMPORT","PARSE");

            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("EXEC_IMPORT","PARSE ERR");
            Log.d("EXEC_IMPORT",e.getMessage());

        }
    }

    private void insertTree(String commonName, String scientificName, String description, String location, String contemporaryUse, String physicalCharacteristics, String care, String pests) {
        db.execSQL("INSERT INTO " + DatabaseHelper.DATABASE_TABLE + " (" +
                        DatabaseHelper.Common_Name + ", " +
                        DatabaseHelper.Scientific_Name + ", " +
                        DatabaseHelper.Description + ", " +
                        DatabaseHelper.Location + ", " +
                        DatabaseHelper.Contemporary_Use + ", " +
                        DatabaseHelper.Physical_Characteristics + ", " +
                        DatabaseHelper.Care + ", " +
                        DatabaseHelper.Pests +
                        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[]{commonName, scientificName, description, location, contemporaryUse, physicalCharacteristics, care, pests});
        Log.d("EXEC_IMPORT","DB IMPORT INSERT TREE");
    }
}
