package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PrivacyPolicyPg extends AppCompatActivity {
    private WebView web;
    public String fileName = "privacypolicy.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy_pg);

        web = (WebView) findViewById(R.id.webview);
        // displaying content in WebView from html file that stored in assets folder
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/" + fileName);
    }
}


