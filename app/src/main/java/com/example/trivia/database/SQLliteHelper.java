package com.example.trivia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trivia.model.History;

import java.util.ArrayList;
import java.util.List;

public class SQLliteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "history_db";


    public SQLliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(History.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + History.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
    public long insertHistory(String date,String name,String cricketer,String colors) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(History.COLUMN_DATETIME, date);
        values.put(History.COLUMN_NAME, name);
        values.put(History.COLUMN_CRICKETER, cricketer);
        values.put(History.COLUMN_COLORS, colors);

        // insert row
        long id = db.insert(History.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public History getHistory(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(History.TABLE_NAME,
                new String[]{History.COLUMN_ID, History.COLUMN_DATETIME,History.COLUMN_NAME,History.COLUMN_CRICKETER,History.COLUMN_COLORS},
                History.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        History note = new History(
                cursor.getInt(cursor.getColumnIndex(History.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(History.COLUMN_DATETIME)),
                cursor.getString(cursor.getColumnIndex(History.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(History.COLUMN_CRICKETER)),
                cursor.getString(cursor.getColumnIndex(History.COLUMN_COLORS)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<History> getAllHistory() {
        List<History> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + History.TABLE_NAME + " ORDER BY " +
                History.COLUMN_COLORS + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                History history = new History();
                history.setId(cursor.getInt(cursor.getColumnIndex(History.COLUMN_ID)));
                history.setDatetime(cursor.getString(cursor.getColumnIndex(History.COLUMN_DATETIME)));
                history.setName(cursor.getString(cursor.getColumnIndex(History.COLUMN_NAME)));
                history.setCricketer(cursor.getString(cursor.getColumnIndex(History.COLUMN_CRICKETER)));
                history.setColors(cursor.getString(cursor.getColumnIndex(History.COLUMN_COLORS)));
                notes.add(history);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getHistoryCount() {
        String countQuery = "SELECT  * FROM " + History.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

}
