package com.example.myartgallery;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Find TextView by its ID
        TextView descriptionTextView = findViewById(R.id.textViewDescription);

        // Read content from the text file
        String aboutContent = readTextFile(R.raw.about_content);

        // Set the text content
        descriptionTextView.setText(aboutContent);
    }

    private String readTextFile(int resourceId) {
        StringBuilder content = new StringBuilder();
        try {
            // Open the raw resource stream
            InputStream is = getResources().openRawResource(resourceId);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Read the content line by line
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Close the stream
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
