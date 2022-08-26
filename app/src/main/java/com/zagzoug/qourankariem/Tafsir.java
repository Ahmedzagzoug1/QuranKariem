package com.zagzoug.qourankariem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.IOException;

public class Tafsir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tafsir);
        WebView webView= (WebView) findViewById(R.id.webtafsir);

            webView.loadUrl("file:///android_asset/glaleen/" + getIntent().getIntExtra(QouranPager.KEY_tafsir,1)  +".htm");
setTitle("تفسير الصفحه "+getIntent().getIntExtra(QouranPager.KEY_tafsir,1) );
    }
}
