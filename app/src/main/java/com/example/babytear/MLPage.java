package com.example.babytear;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;

public class MLPage extends AppCompatActivity {

    private Button send, stop, record, exitbtn;
    private MediaRecorder myAudioRecorder;
    private String outputFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlpage);

        send = (Button) findViewById(R.id.MLsend);
        stop = (Button) findViewById(R.id.MLstop);
        record = (Button) findViewById(R.id.MLrecord);
        stop.setEnabled(false);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                } catch (IllegalStateException ise) {
                    ise.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                record.setEnabled(false);
                stop.setEnabled(true);
                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioRecorder.stop();
                myAudioRecorder.release();
                myAudioRecorder = null;
                record.setEnabled(true);
                stop.setEnabled(false);
                send.setEnabled(true);
                Toast.makeText(getApplicationContext(), "Audio Recorder successfully", Toast.LENGTH_LONG).show();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
