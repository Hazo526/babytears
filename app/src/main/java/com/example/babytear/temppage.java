package com.example.babytear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class temppage extends AppCompatActivity {

    Button exit4btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temppage);

        exit4btn=(Button)findViewById(R.id.exit4btn);

        exit4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit4Intent=new Intent(getApplicationContext(), homepage.class);
                startActivity(exit4btn);
            }
        });
    }
}
