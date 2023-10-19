package com.example.sqllitepractice.database
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.sqllitepractice.profiles

class dbdata(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {


        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "ProfileDB"
        private val TABLE_NAME = "User_info"
        private val KEY_ID = "Id"
        private val KEY_NAME = "Name"
        private val KEY_Phone = "Phone"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_Phone + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }
    fun addEmployee(profile: profiles):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, profile.Name) // EmpModelClass Name
        contentValues.put(KEY_Phone,profile.Age ) // EmpModelClass Phone
        // Inserting Row
        val success = db.insert(TABLE_NAME, null, contentValues)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }
}