package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView websiteList;
    String[] websites = {"Google", "YouTube", "Facebook", "Instagram", "GitHub"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure your XML is updated.

        websiteList = findViewById(R.id.websiteList);

        // Use a custom layout for list items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.list_item_text, websites);
        websiteList.setAdapter(adapter);

        // Set onItemClickListener to open browser using Implicit Intent
        websiteList.setOnItemClickListener((parent, view, position, id) -> {
            String selectedWebsite = websites[position];
            String url = "";

            // Choose URL based on website selected
            switch (selectedWebsite) {
                case "Google":
                    url = "https://www.google.com";
                    break;
                case "YouTube":
                    url = "https://www.youtube.com";
                    break;
                case "Facebook":
                    url = "https://www.facebook.com";
                    break;
                case "Instagram":
                    url = "https://www.instagram.com";
                    break;
                case "GitHub":
                    url = "https://www.github.com";
                    break;
            }

            // Create and start the implicit intent
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}
