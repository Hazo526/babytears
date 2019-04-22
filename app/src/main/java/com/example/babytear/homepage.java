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
import android.widget.ImageView;
import android.widget.TextView;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class homepage extends AppCompatActivity {
    ImageView audiobtn, videobtn, MLbtn;
    Button exitbtn1;
    Button notif;
    public int port = 5560;

    public InetAddress getInet() {
        InetAddress ip;
        try {
            return InetAddress.getByName("172.22.210.157");
        } catch(Exception e)  {
            System.out.println(e);
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        audiobtn = findViewById(R.id.audiobtn);
        videobtn = findViewById(R.id.videobtn);
        exitbtn1 = findViewById(R.id.exitbtn1);
        MLbtn = findViewById(R.id.ML);
        notif = findViewById(R.id.notifText);

        audiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audioIntent = new Intent(getApplicationContext(), WhiteNoise.class);
                startActivity(audioIntent);
            }
        });


        exitbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread (new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket(getInet(), port);
                            OutputStream outStream = socket.getOutputStream();
                            String command = "ALARM";
                            outStream.write(command.getBytes("UTF-8"));
                            command = "EXIT";
                            outStream.write(command.getBytes("UTF-8"));
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    notif.setVisibility(View.VISIBLE);
                                }
                            });
                        }catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }).start();
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

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notif.setVisibility(View.INVISIBLE);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(getInet(), port);
                            OutputStream outStream = socket.getOutputStream();
                            String command = "STOP";
                            outStream.write(command.getBytes("UTF-8"));
                            command = "EXIT";
                            outStream.write(command.getBytes("UTF-8"));
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }).start();
            }
        });
    }
}

