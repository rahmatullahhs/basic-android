package com.example.androidbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Contents extends AppCompatActivity {

    ListView chapterList;
    String[] chapters = {
            "Chapter 1: Android Studio Setup",
            "Chapter 2: Android Studio Anatomy",
            "Chapter 3: UI Layouts",
            "Chapter 4: Activities and Intents",
            "Chapter 5: Views and Widgets",
            "Chapter 6: RecyclerView",
            "Chapter 7: Data Storage",
            "Chapter 8: Networking",
            "Chapter 9: Final Project",
            "Chapter 1: Android Studio Setup",
            "Chapter 2: Android Studio Anatomy",
            "Chapter 3: UI Layouts",
            "Chapter 4: Activities and Intents",
            "Chapter 5: Views and Widgets",
            "Chapter 6: RecyclerView",
            "Chapter 7: Data Storage",
            "Chapter 8: Networking",
            "Chapter 9: Final Project",
            "Chapter 1: Android Studio Setup",
            "Chapter 2: Android Studio Anatomy",
            "Chapter 3: UI Layouts",
            "Chapter 4: Activities and Intents",
            "Chapter 5: Views and Widgets",
            "Chapter 6: RecyclerView",
            "Chapter 7: Data Storage",
            "Chapter 8: Networking",
            "Chapter 9: Final Project"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);

        chapterList = findViewById(R.id.chapterList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, chapters);

        chapterList.setAdapter(adapter);

        // Optional: Handle click on chapter item
        chapterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // You can pass the chapter name or index to the next activity
                Intent intent = new Intent(Contents.this, ChapterDetail.class);
                intent.putExtra("chapterTitle", chapters[position]);
                startActivity(intent);
            }
        });
    }

}

