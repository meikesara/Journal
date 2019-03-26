package com.example.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {

    // Create variable
    private static EntryDatabase entryDatabase;

    // Create constructor
    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create table when app is created
        String create = "CREATE TABLE entries (_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT NOT NULL, content TEXT NOT NULL, mood TEXT, timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP);";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "entries");
        onCreate(db);
    }

    public static EntryDatabase getInstance(Context context) {

        // Create a new EntryDatabase if it has not been created yet
        if (entryDatabase == null) {
            entryDatabase = new EntryDatabase(context, "entries", null, 2);
        }
        return entryDatabase;
    }

    public Cursor selectAll() {

        // Create Cursor
        Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM entries ", null);
        return cursor;
    }

    public void insert(JournalEntry journal) {

        // Get the database
        SQLiteDatabase db = getWritableDatabase();

        // Create new ContentValues and put in the journal variables
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", journal.getTitle());
        contentValues.put("content", journal.getContent());
        contentValues.put("mood", journal.getMood());

        // Insert contentValues into the database
        db.insert("entries", null, contentValues);
    }

    // This method deletes a row based on the id
    public void delete(long id) {
        getWritableDatabase().delete("entries",id + "=" + "_id", null);
    }
}