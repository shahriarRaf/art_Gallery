package com.example.myartgallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ControlFunction extends  AppCompatActivity {

    private ListView menuList;
    private String[] menuItems = {"Show Art", "Online Art Gallery","Art By Artist","Logout", "About App"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_function);

        menuList = findViewById(R.id.menu_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click and navigate to the next activity
                switch (position) {
                    case 0:
                        // Handle "Upload Art show" click
                        startActivity(new Intent(ControlFunction.this,UploadActivity1.class));
                        break;
                    case 1:
                        // Online Art gallery
                         startActivity(new Intent(ControlFunction.this, LinkActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ControlFunction.this, EnterArtistName.class));
                        break;
                    case 3:
                       //logout
                        startActivity(new Intent(ControlFunction.this,MainActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(ControlFunction.this,AboutActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
