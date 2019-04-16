package com.example.babytear;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Socket;


import java.io.OutputStream;



import java.net.InetAddress;



public class WhiteNoise extends AppCompatActivity {
    private Button whitenoiseplay, whitenoisesend, lullabyplay, lullabysend, choirplay, choirsend, whitenoisestop, lullabystop, choirstop;
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
                whitenoisesound.pause();
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

        whitenoisesend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread (new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(getInet(), port);
                            OutputStream outStream = socket.getOutputStream();
                            String command = "PLAY1";
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

        lullabyplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lullabysound.start();
            }
        });

        lullabystop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lullabysound.pause();
                new Thread (new Runnable() {
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

        lullabysend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread (new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(getInet(), port);
                            OutputStream outStream = socket.getOutputStream();
                            String command = "PLAY2";
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

        choirplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choirsound.start();
            }
        });

        choirstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choirsound.pause();
                new Thread (new Runnable() {
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

        choirsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread (new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(getInet(), port);
                            OutputStream outStream = socket.getOutputStream();
                            String command = "PLAY3";
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
