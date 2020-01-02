package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Viene nascosta la StausBar
        setContentView(R.layout.splash_theme); //Viene settato il Layout
        mProgressBar = findViewById(R.id.progressBar); //Viene referenziata la ProgressBar presente nel layout

        // Creo un thread per l'avanzamento della ProgressBar
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Quando la ProgressBar arriva al 100% viene aperta la MainActivity
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                });
            }
        }).start();
    }
}