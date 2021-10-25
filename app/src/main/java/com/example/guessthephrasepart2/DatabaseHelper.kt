package com.example.guessthephrasepart2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context): SQLiteOpenHelper(context,"phrases.db",null,1) {
    var sqLiteDatabase: SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL("create table phrases (Phrase text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS phrases")
        onCreate(sqLiteDatabase)
    }
    fun saveData(phrase:String): Long {
        val n= ContentValues()
        n.put("Phrase",phrase)
        var status =  sqLiteDatabase.insert("phrases",null,n)
        return status
    }

    fun retrieveData(): ArrayList<String> {
        val phrases=ArrayList<String>()
        var c=sqLiteDatabase.rawQuery("SELECT * FROM phrases",null)

        //iterate through cursor and save to array list
        if (c != null) {
            while (c.moveToNext())
            {
                var note = c.getString(0)

                phrases.add(note)
            }
        }
        return phrases
    }

}