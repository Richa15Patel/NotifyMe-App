package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:notifymehelpout@gmail.com"));
            //putExtra - sets subject of email...
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Help Request");
        startActivity(Intent.createChooser(emailIntent, "Send Email"));

    }
}