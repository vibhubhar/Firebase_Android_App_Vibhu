package com.example.user.cortarandroidapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){
        super(context, "login.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("Create table user(email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
   db.execSQL("drop table if exists user");
    }
    /* insert data */
    public boolean Insert(String email,String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins== -1)
            return false;
        else
            return true;
    }

    // checking email if exists.
    public boolean Chkemail(String email){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where email=?", new String[]{
                email
        });
        if(cursor.getCount()>0) {
            cursor.moveToNext();
            return false;
        }
        else
            return true;
    }
    //checking the email password
    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
