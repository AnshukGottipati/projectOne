package com.example.projectone;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "accountPassword.db";
    private static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    private static final String COLUMN_WEBSITE = "WEBSITE";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String COLUMN_PASSWORD = "PASSWORD";
    private static final String COLUMN_ID = "ID";
    private Context context;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + CUSTOMER_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEBSITE + " TEXT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT);";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_TABLE);
        onCreate(db);
    }

    public void addOne(String website, String email, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WEBSITE,website);
        cv.put(COLUMN_USERNAME,email);
        cv.put(COLUMN_PASSWORD,Password);

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if(insert == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + CUSTOMER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void updateData(String website,String email,String password,String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_WEBSITE,website);
        cv.put(COLUMN_USERNAME,email);
        cv.put(COLUMN_PASSWORD,password);

        long result = db.update(CUSTOMER_TABLE,cv," id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context,"Failed to Update", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully Added", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteData(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(CUSTOMER_TABLE," id=?",new String[]{row_id});

        if(result == -1){
            Toast.makeText(context,"Failed to remove", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully removed", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + CUSTOMER_TABLE);
    }


}
