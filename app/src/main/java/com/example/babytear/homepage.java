package com.example.babytear;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class homepage extends AppCompatActivity {
    Button audiobtn, videobtn, exitbtn1, MLbtn, notifbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        audiobtn = (Button) findViewById(R.id.audiobtn);
        videobtn = (Button) findViewById(R.id.videobtn);
        exitbtn1 = (Button) findViewById(R.id.exitbtn1);
        MLbtn = (Button) findViewById(R.id.ML);
        notifbtn = (Button) findViewById(R.id.notifbtn);

        audiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audioIntent = new Intent(getApplicationContext(), audiopage.class);
                startActivity(audioIntent);
            }
        });


        exitbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit1Intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(exit1Intent);
            }
        });


        videobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent = new Intent(getApplicationContext(), videopage.class);
                startActivity(videoIntent);
            }
        });

        MLbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mlIntent = new Intent(getApplicationContext(), MLPage.class);
                startActivity(mlIntent);
            }
        });
    }
}

