package com.example.androidbook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private TextView splashText;
    private final String message = "Page and Play";
    private int index = 1; // Start from 1 to avoid substring(0, 0) showing empty at first
    private final long delay = 150;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            if (index <= message.length()) {
                splashText.setText(message.substring(0, index));
                index++;
                handler.postDelayed(this, delay);
            } else {
                // Wait 2 seconds and then move to Home activity
                handler.postDelayed(() -> {
                    startActivity(new Intent(Splash.this, Home.class));
                    finish();
                }, 2000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashText = findViewById(R.id.splash); // Make sure this ID exists in your layout
        handler.postDelayed(characterAdder, delay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(characterAdder);
    }
}
