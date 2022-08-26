package com.zagzoug.qourankariem;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.zagzoug.qourankariem.database.AyaDB;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Searching extends AppCompatActivity {
ListView lv;
    ArrayAdapter<String> adapter;

    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        AyaDB db=new AyaDB(this);

        lv= (ListView) findViewById(R.id.lv_search);
        DatabaseHelper myDbHelper = new DatabaseHelper(this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        Toast.makeText(this, "Successfully Imported", Toast.LENGTH_SHORT).show();
        c = myDbHelper.query("TIDEPRED", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                Toast.makeText(this,
                        "_id: " + c.getString(0) + "\n" +
                                "DATE: " + c.getString(1) + "\n" +
                                "TIME: " + c.getString(2) + "\n" +
                                "HEIGHT:  " + c.getString(3),
                        Toast.LENGTH_LONG).show();
            } while (c.moveToNext());
        }




      //  adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, s);
  //  lv.setAdapter(adapter);
    }
}
