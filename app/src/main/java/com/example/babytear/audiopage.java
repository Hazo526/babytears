package com.example.babytear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class audiopage extends AppCompatActivity {

    Button exit2btn, recordbtn, playbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiopage);

        recordbtn = (Button)findViewById(R.id.record2btn);

        recordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent record2Intent = new Intent(getApplicationContext(), RecordAudio.class);
                startActivity(record2Intent);
            }
        });

        playbtn = (Button)findViewById(R.id.playback2btn);

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play2Intent = new Intent(getApplicationContext(), PlaybackAudio.class);
                startActivity(play2Intent);
            }
        });

        exit2btn = (Button)findViewById(R.id.exitaudiobtn);

        exit2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit2Intent = new Intent(getApplicationContext(), homepage.class);
                startActivity(exit2Intent);
            }
        });
    }
}
