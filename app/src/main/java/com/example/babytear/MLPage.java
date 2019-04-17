package com.example.babytear;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MLPage extends AppCompatActivity {

    private Button why, exitMLbtn;
    public int port = 5560;
    public String thisMessage = "";
    public TextView belly, burping, discomfort, hungry, tired, none;

    public InetAddress getInet() {
        InetAddress ip;
        try {
            return InetAddress.getByName("10.27.144.226");
        } catch(Exception e)  {
            System.out.println(e);
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlpage);

        why = (Button) findViewById(R.id.MLwhy);

        belly=findViewById(R.id.textView1);
        burping=findViewById(R.id.textView2);
        discomfort=findViewById(R.id.textView3);
        hungry=findViewById(R.id.textView4);
        tired=findViewById(R.id.textView5);
        none=findViewById(R.id.textView6);

        why.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Socket socket = new Socket(getInet(), port);
                            OutputStream outStream = socket.getOutputStream();
                            DataInputStream dis = new DataInputStream(socket.getInputStream());



                            String command = "PREDICT";
                            outStream.write(command.getBytes("UTF-8"));

                            boolean end = false;
                            byte[] messageByte = new byte[1000];
                            while(!end) {
                                int bytesRead = dis.read(messageByte);
                                /* added final */
                                final String message = new String(messageByte, 0, bytesRead);
                                if (message.length() == 10) { //change length
                                    end = true;
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (message.equals("belly pain")){
                                            belly.setVisibility(View.VISIBLE);
                                        }
                                        else if(message.equals("burping")){
                                            burping.setVisibility(View.VISIBLE);
                                        }
                                        else if(message.equals("discomfort")){
                                            discomfort.setVisibility(View.VISIBLE);
                                        }
                                        else if(message.equals("--hungry--")){
                                            hungry.setVisibility(View.VISIBLE);
                                        }
                                        else if(message.equals("---tired--")){
                                            tired.setVisibility(View.VISIBLE);
                                        }
                                        else if(message.equals("---none---")){
                                            none.setVisibility(View.VISIBLE);
                                        }
                                        else {
                                            belly.setVisibility(View.VISIBLE);
                                            burping.setVisibility(View.VISIBLE);
                                            discomfort.setVisibility(View.VISIBLE);
                                            hungry.setVisibility(View.VISIBLE);
                                            tired.setVisibility(View.VISIBLE);
                                            none.setVisibility(View.VISIBLE);
                                        }
                                    }
                                });
                            }
                            command = "EXIT";
                            outStream.write(command.getBytes("UTF-8"));
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }).start();
            }
        });

        exitMLbtn=findViewById(R.id.exitMLbtn);
        exitMLbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitMLintent = new Intent(getApplicationContext(), homepage.class);
                startActivity(exitMLintent);
            }
        });
    }
}
