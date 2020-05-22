package com.example.pandemicpack

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
val DATABASENAME = "MY DATABASE"
val TABLENAME = "Ideas"
val COL_NAME = "colIdea"
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_NAME + " VARCHAR(256)) "
        db?.execSQL(createTable)
      /*
        **/
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }
    fun insertData(ide: Idea) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, ide.colIdeas)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "New Idea Added", Toast.LENGTH_SHORT).show()
        }
    }
    fun readData():MutableList<Idea>   {
        val list: MutableList<Idea> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val ide = Idea()
                ide.colIdeas = result.getString(result.getColumnIndex(COL_NAME))
                list.add(ide)
            }
            while (result.moveToNext())
        }
        return list
    }
}