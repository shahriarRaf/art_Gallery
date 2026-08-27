package com.example.myartgallery;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsOfArt extends AppCompatActivity {
    TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_art);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);
        textView1.setText(getIntent().getStringExtra("value1"));
        textView2.setText(getIntent().getStringExtra("value2"));
        textView3.setText(getIntent().getStringExtra("value3"));

    }
}