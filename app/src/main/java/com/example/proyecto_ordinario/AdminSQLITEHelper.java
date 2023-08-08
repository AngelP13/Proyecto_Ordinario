package com.example.proyecto_ordinario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLITEHelper extends SQLiteOpenHelper {
    public AdminSQLITEHelper(Context context,String producto,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, producto, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table alumnos(id integer primary key autoincrement, producto text,precio text,fecha DATE default(datetime('now','localtime')) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
