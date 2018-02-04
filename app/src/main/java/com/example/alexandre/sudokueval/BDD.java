package com.example.alexandre.sudokueval;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BDD {
    BDDHelper helper;
    SQLiteDatabase base;

    public void open(Context activity) throws SQLException {
        helper = new BDDHelper(activity);
        base = helper.getWritableDatabase();
    }
}
