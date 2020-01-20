package com.example.groupchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    TextView tv;
    ImageView iv;
    Animation frombottom, fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv = findViewById(R.id.gchat);
        iv = findViewById(R.id.chat_image);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        tv.setAnimation(frombottom);
        iv.setAnimation(fromtop);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    iv.startAnimation(fromtop);
                    tv.startAnimation(frombottom);
                    sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
    }

}
