package com.example.myartgallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterArtistName extends AppCompatActivity {
    EditText editText;
    Button bttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_artist_name);
        editText=(EditText) findViewById(R.id.in);
        bttn=(Button) findViewById(R.id.bt);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EnterArtistName.this, ListOfArt.class);
                String string=editText.getText().toString();
                intent.putExtra("artistName",string);
                startActivity(intent);
            }
        });
    }
}