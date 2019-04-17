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
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MLPage extends AppCompatActivity {

    private Button why, exitbtn;
    public int port = 5560;
    public String thisMessage = "";

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
                                String message = new String(messageByte, 0, bytesRead);
                                if (message.length() == 10) { //change length
                                    end = true;
                                }
                                System.out.println(message); //replace this with function calls
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

    }

}
