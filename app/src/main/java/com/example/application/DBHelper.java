package com.example.application;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "registration.db" ;
    public static final String TBNAME = "registration" ;
    public static final int DB_VERSION= 1 ;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TBNAME+ "(dname VARCHAR, dpass VARCHAR"+");");
        db.execSQL("INSERT INTO registration  VALUES('admin','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBNAME);
        onCreate(db);
    }

    public long adduser(String name, String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase() ;
        ContentValues cv = new ContentValues() ;
        cv.put("dname",name);
        cv.put("dpass",pass);
        long result =  sqLiteDatabase.insert(TBNAME,null,cv);
        sqLiteDatabase.close();
        return result;
    }

    public void delete(String name, Context ctx){
        SQLiteDatabase db = this.getWritableDatabase() ;
        db.execSQL("DELETE FROM "+TBNAME+ " WHERE dname='"+name+"';");
        Toast.makeText(ctx, "Entry Deleted", Toast.LENGTH_SHORT).show();
        db.close();
    }
    public void update(String name, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cur = db.rawQuery("update "+TBNAME+" set dname ='"+name+"',"+ "dpass = '"+pass+"';",null);
        db.execSQL("UPDATE "+TBNAME+" SET dname ='"+name+"',"+ "dpass = '"+pass+"';");
        db.close();
    }

    public String display(Context ctx){
        SQLiteDatabase db = this.getReadableDatabase() ;
        @SuppressLint("Recycle") Cursor cur = db.rawQuery("SELECT * FROM "+TBNAME+";",null);
        String finalres =" ";
        while(cur.moveToNext()){
            finalres = cur.getString(1)+":"+cur.getString(2) ;
        }
        return finalres ;
    }
}
