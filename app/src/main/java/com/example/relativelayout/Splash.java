package com.example.relativelayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.os.Handler;
import android.content.Intent;
import android.animation.ObjectAnimator;

public class Splash extends AppCompatActivity {
    ProgressBar splashProgress;
    int SPLASH_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(mySuperIntent);
                finish();

            }
        }, SPLASH_TIME);
    }
}


