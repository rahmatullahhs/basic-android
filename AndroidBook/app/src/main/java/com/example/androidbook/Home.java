package com.example.androidbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {
Button contentsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        contentsBtn =findViewById(R.id.contentsBtn);

       contentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open reading activity (next screen)
                Intent intent = new Intent(Home.this,Contents.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getSharedPreferences("ReadingProgress", MODE_PRIVATE);
        String lastChapter = prefs.getString("LastChapter", null);

        if (lastChapter != null) {
            Toast.makeText(this, "Last read: " + lastChapter, Toast.LENGTH_LONG).show();
        }
    }

}
