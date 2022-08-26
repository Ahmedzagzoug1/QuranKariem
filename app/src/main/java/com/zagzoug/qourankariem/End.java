package com.zagzoug.qourankariem;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class End extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
         WebView webView= (WebView) findViewById(R.id.web_end);

        webView.loadUrl("file:///android_asset/end.htm");
    }
}
