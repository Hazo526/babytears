package com.example.babytear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class audiopage extends AppCompatActivity {

    Button exit2btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiopage);

        exit2btn = (Button)findViewById(R.id.exit2btn);

        exit2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit2Intent = new Intent(getApplicationContext(), homepage.class);
                startActivity(exit2Intent);
            }
        });
    }
}
