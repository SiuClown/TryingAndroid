package com.example.coldstoragemanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBOpenHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public DBOpenHelper(Context context){
        super(context,"mydb",null,1);
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT," +
                "password TEXT," +
                "phone TEXT," +
                "mail TEXT," +
                "position TEXT," +
                "create_time DATATIME," +
                "update_time DATATIME)");
        //表创建操作
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
        //表更新操作
    }

    public void add(String name,String password,String phone,String mail,String position){
        db.execSQL("INSERT INTO user (name,password,phone,mail,position) VALUES(?,?)",new Object[]{name,password});
        //表中添加数据操作
    }

    public void delete(String name,String password,String phone,String mail,String position){
        db.execSQL("DELETE FROM user WHERE name = AND password" + name + password);
        //表中删除数据操作
    }

    public void update(String password){
        db.execSQL("UPDATE user SET password = ?",new Object[]{password});
        //表中更新数据操作
    }

    public ArrayList<User> getAllDate(){

        ArrayList<User> list = new ArrayList<>();
        //游标创建，参与使用
        Cursor cursor = db.query("user",null,null,null,null,null,"name DESC");
        while (cursor.moveToNext()){
            @SuppressLint("Range")
            String name = cursor.getString(cursor.getColumnIndex("name"));
            @SuppressLint("Range")
            String password = cursor.getString(cursor.getColumnIndex("password"));


        }
        return list;
    }



}
