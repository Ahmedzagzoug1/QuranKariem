package com.zagzoug.qourankariem;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class SplashActivity extends AppCompatActivity {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new CountDownTimer(5000,4000){

            @Override
            public void onTick(long millisUntilFinished) {

             //   MediaPlayer.create(SplashActivity.this,R.raw.splash_sound).start();
            }

            @Override
            public void onFinish() {
          Intent      intent=new Intent(SplashActivity.this,QouranPager.class);

                startActivity(intent);
                finish();
            }
        }.start();
    }
}
