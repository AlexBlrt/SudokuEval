package com.example.alexandre.sudokueval;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDDHelper extends SQLiteOpenHelper {
    public BDDHelper(Context context) {
        super(context, "sudoku.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE parties (_id INTEGER PRIMARY KEY AUTOINCREMENT, number TEXT NOT NULL, level TEXT NOT NULL, time_passed TEXT NOT NULL, completion TEXT NOT NULL, cases TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
