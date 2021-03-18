package com.example.xyzreader.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.xyzreader.DB.Itemshow.Tables;

public class ItemDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "xyzreader.db";
    private static final int DATABASE_VERSION = 2;

    public ItemDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Tables.ITEMS + " ("
                + Itemsmodel.ItemsColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Itemsmodel.ItemsColumns.SERVER_ID + " TEXT,"
                + Itemsmodel.ItemsColumns.TITLE + " TEXT NOT NULL,"
                + Itemsmodel.ItemsColumns.AUTHOR + " TEXT NOT NULL,"
                + Itemsmodel.ItemsColumns.BODY + " TEXT NOT NULL,"
                + Itemsmodel.ItemsColumns.THUMB_URL + " TEXT NOT NULL,"
                + Itemsmodel.ItemsColumns.PHOTO_URL + " TEXT NOT NULL,"
                + Itemsmodel.ItemsColumns.ASPECT_RATIO + " REAL NOT NULL DEFAULT 1.5,"
                + Itemsmodel.ItemsColumns.PUBLISHED_DATE + " TEXT NOT NULL"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tables.ITEMS);
        onCreate(db);
    }
}
