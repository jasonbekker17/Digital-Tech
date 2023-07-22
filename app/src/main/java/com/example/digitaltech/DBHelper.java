package com.example.digitaltech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "App.db";
    final String secretKey="donottouch";

    public DBHelper(Context context ) {
        super(context, "App.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(id INTEGER PRIMARY KEY AUTOINCREMENT, fullname TEXT, email TEXT, password VARCHAR)");
        db.execSQL("create Table incidences(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, incident TEXT, phone_number INT, gender TEXT, first_name TEXT, last_name TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists users");
        db.execSQL("drop Table if exists incidences");


    }
    public boolean insertIncident(IncidentModel incidentModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email",incidentModel.getEmail());
        cv.put("incident", incidentModel.getIncident());
        cv.put("gender", incidentModel.getGender());
        cv.put("phone_number", incidentModel.getPhone_number());
        cv.put("first_name", incidentModel.getFirstname());
        cv.put("last_name", incidentModel.getLastname());


        long result = db.insert("incidences", null, cv);
        if(result == -1) return false;
        else
            return true;

    }

    public boolean insertData(String email, String fullname, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fullname", fullname);
        cv.put("email", email);
        cv.put("password", password);

        long result = db.insert("users", null, cv);
        if(result == -1) return false;
        else
            return true;

    }

    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ?", new String[] {email});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        MyAES myAES= new MyAES();
        password=myAES.dencrypt(password,secretKey);

        Cursor cursor = db.rawQuery("select * from users where email = ? and password = ?" , new String[] {email, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
