package com.bpm.aarsad.bpmmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = (TextView) findViewById(R.id.splash_text);
        imageView = (ImageView) findViewById(R.id.splash_image);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);

        final Intent i = new Intent(this, LoginActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();
    }
}
