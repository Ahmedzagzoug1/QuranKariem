package com.zagzoug.qourankariem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
