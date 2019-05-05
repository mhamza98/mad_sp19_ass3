package com.example.my_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper {

    public dbhelper(Context context) {
        super(context, "signupdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table signup(id integer primary key autoincrement, name text, father text, phone text, " +
                "dob text, email text UNIQUE, password text, address text,gender text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists signup");
    }

    public boolean insertion(String name, String father, String phone, String dob, String email, String password, String address,String gender,int call)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name",name);
        values.put("father",father);
        values.put("phone",phone);
        values.put("dob",dob);
        values.put("email",email);
        values.put("password",password);
        values.put("address",address);
        values.put("gender",gender);
        long isInserted;
        if(call == 1)
            isInserted= db.insert("signup",null,values);
        else {
            String[] where = {email};
            isInserted = db.update("signup", values, "email = ?", where);
        }
        if (isInserted==-1)
            return false;
        else
            return true;
    }

    public Cursor getInfo()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor data = db.rawQuery("select *from signup",null);

        return data;
    }
}
