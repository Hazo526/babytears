package com.example.babytear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class PlaybackAudio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_playbackpage);

        ArrayList<String> list = new ArrayList<>();
        list.add("White noise");
        list.add("Harmonious choir");
        list.add("lullay");

        CustomAudioAdaptor adaptor = new CustomAudioAdaptor(list, this);

        ListView lview = (ListView) findViewById(R.id.lvPlayback);
        lview.setAdapter(adaptor);

        Button backbtn = (Button)findViewById(R.id.playbackbackbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit2Intent = new Intent(getApplicationContext(), audiopage.class);
                startActivity(exit2Intent);
            }
        });
    }
}