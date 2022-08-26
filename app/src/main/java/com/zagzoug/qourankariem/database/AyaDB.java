package com.zagzoug.qourankariem.database;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Ahmed on 5/5/2019.
 */

public class AyaDB extends SQLiteOpenHelper {

    public static final String DB_NAME= "aya.db";
    public static final int DB_VERSION=1;
    public static   String dbPath;

    SQLiteDatabase database;
    Context context;
    public AyaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    this.context=context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
    return;
             }
        }

        dbPath= Environment.getDataDirectory()+"/data/"+context.getPackageName()+"/databases/";
       copyDataBase();
        openDataBase();
       this.getReadableDatabase();

    }

    private void copyDataBase() {
        File dbFile=new File(dbPath+DB_NAME);
        if (!dbFile.exists()) {
           this. getReadableDatabase();

            try {


                InputStream fis = context.getAssets().open(DB_NAME);
                FileOutputStream fos = new FileOutputStream(dbPath+DB_NAME);

                byte[] buffer = new byte[1024];
                int i;
                while ((i = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, i);
                    fos.flush();
                    fos.close();
                    fis.close();
                }
                Log.d("db", fos.toString());
            } catch (FileNotFoundException e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
            close();

        }


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void openDataBase(){

        if (database==null || database.isOpen())
            return ;
        try {
            database = SQLiteDatabase.openDatabase(dbPath + DB_NAME, null, SQLiteDatabase.OPEN_READONLY);

        }catch (Exception e){
            Toast.makeText(context, "cannot open"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public ArrayList<String> getAyat(){
         this.getReadableDatabase();
        ArrayList<String>ayat=new ArrayList<>();
        try {
            Log.d("db",database.isOpen()+"-"+database.getMaximumSize()+database.getVersion()+"-"+database.getVersion());

            Cursor cursor = database.rawQuery("SELECT * FROM ayat ;",null);
            if (cursor.moveToFirst()) {
                while (cursor.moveToNext()) {
                    String aya = cursor.getString(cursor.getColumnIndex("text"));
                    String sura = cursor.getString(cursor.getColumnIndex("sura"));
                    String safha = cursor.getString(cursor.getColumnIndex("safha"));

                    ayat.add(aya + sura + safha);
                }

            }
            cursor.close();

        }catch (Exception e){
            Toast.makeText(context.getApplicationContext(), "cannot open"+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("db",e.getMessage());
        }
        return ayat;
    }

    @Override
    public synchronized void close() {
    if (database!=null)
database.close();
        super.close();

    }
}
