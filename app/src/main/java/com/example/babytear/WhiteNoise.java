package com.example.babytear;

import android.os.AsyncTask;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhiteNoise extends AppCompatActivity {
    private Button whitenoiseplay, whitenoisesend, lullabyplay, lullabysend, choirplay, choirsend, whitenoisestop, lullabystop, choirstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_noise);
        whitenoiseplay = findViewById(R.id.whitenoiseplay);
        whitenoisesend = findViewById(R.id.whitenoisesend);
        whitenoisestop = findViewById(R.id.whitenoisestop);
        lullabyplay = findViewById(R.id.lullabyplay);
        lullabysend = findViewById(R.id.lullabysend);
        lullabystop = findViewById(R.id.lullabystop);
        choirplay = findViewById(R.id.choirplay);
        choirsend = findViewById(R.id.choirsend);
        choirstop = findViewById(R.id.choirstop);

        final MediaPlayer whitenoisesound = MediaPlayer.create(this, R.raw.whitenoise);
        final MediaPlayer lullabysound = MediaPlayer.create(this, R.raw.lullaby);
        final MediaPlayer choirsound = MediaPlayer.create(this, R.raw.choir);

        whitenoiseplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whitenoisesound.start();
            }
        });

        whitenoisestop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whitenoisesound.stop();
            }
        });

        whitenoisesend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /* */
            }
        });

        lullabyplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lullabysound.start();
            }
        });

        lullabystop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lullabysound.stop();
            }
        });

        choirplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choirsound.start();
            }
        });

        choirstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choirsound.stop();
            }
        });




    }
}