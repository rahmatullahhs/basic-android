package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    private TextView splashText;
    private String message = "Welcome to JEE 64";

    private int index = 0;
    private long delay = 150; // milliseconds

    private Handler handler = new Handler();

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            // Add one character at a time
            splashText.setText(message.substring(0, index++));

            if (index <= message.length()) {
                handler.postDelayed(this, delay);
            } else {
                // After full message is displayed, wait a bit and go to Login
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Splash.this, Login.class));
                        finish();
                    }
                }, 1000); // Delay before moving to next activity
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        splashText = findViewById(R.id.splashText); // make sure this ID exists in your XML

        handler.postDelayed(characterAdder, delay);

    }
}