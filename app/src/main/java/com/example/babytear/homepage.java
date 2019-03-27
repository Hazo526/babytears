package com.example.babytear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    Button audiobtn, videobtn, exitbtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        audiobtn=(Button)findViewById(R.id.audiobtn);
        videobtn=(Button)findViewById(R.id.videobtn);
        exitbtn1=(Button)findViewById(R.id.exitbtn1);

        audiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audioIntent = new Intent(getApplicationContext(), audiopage.class);
                startActivity(audioIntent);
            }
        });

        videobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent = new Intent(getApplicationContext(), videopage.class);
                startActivity(videoIntent);
            }
        });

        exitbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit1Intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(exit1Intent);
            }
        });

    }
}
