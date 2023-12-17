package com.example.hub;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class LOADING extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading2);

        ImageView gifImageView = findViewById(R.id.gifImageView);
        // Load and display the GIF using Glide
        Glide.with(this)
                .load(R.drawable.giphy)  // Assuming 'giphy' is the GIF resource in your drawable folder
                .into(gifImageView);

        // Delay for 3 seconds (3000 milliseconds) and then transition to MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LOADING.this, MainActivity.class);
                startActivity(intent);
                finish();  // Close the splash screen activity
            }
        }, SPLASH_DURATION);
    }
}
