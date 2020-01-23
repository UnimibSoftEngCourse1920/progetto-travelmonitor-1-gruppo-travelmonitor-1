package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler myHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_theme); //Viene settato il Layout
        mProgressBar = findViewById(R.id.progressBar); //Viene referenziata la ProgressBar presente nel layout

        // Creo un thread per l'avanzamento della ProgressBar
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(20);
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Quando la ProgressBar arriva al 100% viene aperta la Preferiti e "chiusa" quella attuale(SplashActivity)
                        startActivity(new Intent(SplashActivity.this, Preferiti.class));
                        finish();
                    }
                });
            }
        }).start();
    }
}