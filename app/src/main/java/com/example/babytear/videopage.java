package com.example.babytear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class videopage extends AppCompatActivity {

    Button exit3btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videopage);

        exit3btn=(Button)findViewById(R.id.exit3btn);

        exit3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit3Intent=new Intent(getApplicationContext(), homepage.class);
                startActivity(exit3Intent);
            }
        });
    }
}
