package com.example.myartgallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LinkActivity extends AppCompatActivity {

    private ListView linkListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        linkListView = findViewById(R.id.linkListView);

        // Create an ArrayAdapter to display the links in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getLinksArray());
        linkListView.setAdapter(adapter);

        // Set a click listener for the ListView items
        linkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedLink = getLinkByPosition(position);
                openLink(selectedLink);
            }
        });
    }

    private void openLink(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }



    private String getLinkByPosition(int position) {
        String[] linksArray = {
                "https://www.rawpixel.com/create/search?page=1&path=432&sort=curated",
                "https://www.vadehraart.com/",
                "https://www.artsy.net/",
                "https://www.metmuseum.org/",
                "https://www.aucklandartgallery.com/",
                "https://www.nationalgallery.org.uk/",
                "https://artsandculture.google.com/"
        };

        if (position >= 0 && position < linksArray.length) {
            return linksArray[position];
        } else {
            return "";
        }
    }



    private String[] getLinksArray() {
        return new String[]{
                "Rawpixel",
                "Vadehraart",
                "Artsy",
                "Metmuseum",
                "Auckland Art Gallery",
                "National Gallery",
                "Art Sand Culture"
        };
    }
}


