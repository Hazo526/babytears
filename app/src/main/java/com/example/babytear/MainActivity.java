package com.example.babytear;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login;
    ImageView dtrump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer dtrumpsound= MediaPlayer.create(this, R.raw.dtrumpsound);
        username=findViewById(R.id.usereditText);
        password=findViewById(R.id.pweditText);
        login=findViewById(R.id.loginbtn);
        dtrump=findViewById(R.id.dtrumpimageview);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(username.getText().toString(), "nithya")&&Objects.equals(password.getText().toString(),"niti"))
                {
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    Intent logintent = new Intent(getApplicationContext(), homepage.class);
                    startActivity(logintent);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"Wrong Username/Password",Toast.LENGTH_LONG).show();
                    dtrump.setVisibility(View.VISIBLE);
                    dtrumpsound.start();

                }
            }
        });
    }
}


