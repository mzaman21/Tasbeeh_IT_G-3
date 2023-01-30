package com.example.tasbeehapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

public class DBhelper extends SQLiteOpenHelper {

    public static final String TasbeehID = "TasbeehID";
    public static final String TodayDate= "today_date";
    public static final String KalmaCount = "Kalma_Count";
    public static final String DaroodCount = "Darood_Count";
    public static final String AstgfarCount = "Astgfar_Count";
    public static final String Tasbeeh_TABLE = "TasbeehTable";

    public DBhelper(Context context) {
        super(context,"TasbeehDb.db",null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase TasbeehDb) {
        String createTableSTatement = "CREATE TABLE " + Tasbeeh_TABLE + "(" + TasbeehID + " Date PRIMARY KEY AUTOINCREMENT, " + TodayDate + " Text, " + KalmaCount + " Int, " + DaroodCount + " Int, " + AstgfarCount + " Int) ";
        TasbeehDb.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void  addTasbeeh(TasbeehModel Today_Tasbeeh){
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv= new ContentValues();

        cv.put(TodayDate, Today_Tasbeeh.getToday_date());
        cv.put(KalmaCount, Today_Tasbeeh.getKalma_Count());
        cv.put(DaroodCount, Today_Tasbeeh.getDarood_Count());
        cv.put(AstgfarCount, Today_Tasbeeh.getAstgfar_Count());

        db.insert(Tasbeeh_TABLE, null, cv);
        db.close();
    }
    public ArrayList<TasbeehModel> getAllTasbeeh() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Tasbeeh_cursor = db.rawQuery("SELECT * FROM " + Tasbeeh_TABLE, null);

        ArrayList<TasbeehModel> TasbeehArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (Tasbeeh_cursor.moveToFirst()) {
            do {
                TasbeehArrayList.add(new TasbeehModel(
                        Tasbeeh_cursor.getString(1),
                        Tasbeeh_cursor.getInt(2),
                        Tasbeeh_cursor.getInt(3),
                        Tasbeeh_cursor.getInt(4)
                        )
                );
            } while (Tasbeeh_cursor.moveToNext());

        }

        Tasbeeh_cursor.close();
        return TasbeehArrayList;
    }

}
