package com.example.coldstoragemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mSqliteopenhelper extends SQLiteOpenHelper {
    private static  String DB_NAME="mSqlite.db";

    private static final String create_users="create table user(name varchar(32),password varchar(32))";

    public mSqliteopenhelper(@Nullable Context context){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long User_register(User user){
        SQLiteDatabase db_r = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",user.getName());
        cv.put("password",user.getPassword());
        long users = db_r.insert("user",null,cv);
        return users;
    }

/*    public long User_Login(String name,String password){
        boolean result = false;
        SQLiteDatabase db_l = getWritableDatabase();

    }*/
}
