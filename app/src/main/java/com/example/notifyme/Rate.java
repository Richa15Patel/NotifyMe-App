package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class Rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

            // getPackageName() - returns the package name of the current application....
            //URI - for the Google Play Store... Add app name after launching app in GPS...
            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent rateIntent = new Intent(Intent.ACTION_VIEW, uri);

            // 0 - resolveActivity is set to default behavior....
            if (getPackageManager().resolveActivity(rateIntent, 0) == null) {
                Toast.makeText(this, "Unable to open app store", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(rateIntent);
            }

    }
}