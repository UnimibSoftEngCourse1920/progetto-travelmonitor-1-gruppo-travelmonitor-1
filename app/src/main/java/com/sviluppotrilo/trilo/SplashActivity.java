package com.sviluppotrilo.trilo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.preference.PowerPreference;
import com.sviluppotrilo.trilo.Domain.Giorno;


public class SplashActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_theme); //Viene settato il Layout
        mProgressBar = findViewById(R.id.progressBar); //Viene referenziata la ProgressBar presente nel layout

        //Inizializzazione dei preferiti
        initPreferiti();

        //Inizializza la libreria LocalDate
        AndroidThreeTen.init(this);

        //Inizializza il canale su cui inviare le notifiche push
        PushNotification.init(this);

        scheduleJob();

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
    public void scheduleJob() {
        ComponentName componentName = new ComponentName(this, Schedulatore.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(info);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d("Prova", "Job scheduled");
        } else {
            Log.d("Prova", "Job scheduling failed");
        }
    }

    private void initPreferiti(){
        PowerPreference.init(this);
        if(!PowerPreference.getDefaultFile().getBoolean("firstTime", false)) {
            firstRun();
            PowerPreference.getDefaultFile().setBoolean("firstTime", true);
        }
    }

    private void firstRun(){
        Giorno lunedi = new Giorno(1, "Lunedi");
        boolean result = PowerPreference.getDefaultFile().setObject("Lunedi", lunedi);
        Giorno martedi = new Giorno(2, "Martedi");
        result = PowerPreference.getDefaultFile().setObject("Martedi", martedi);
        Giorno mercoledi = new Giorno(3, "Mercoledi");
        result = PowerPreference.getDefaultFile().setObject("Mercoledi", mercoledi);
        Giorno giovedi = new Giorno(4, "Giovedi");
        result = PowerPreference.getDefaultFile().setObject("Giovedi", giovedi);
        Giorno venerdi = new Giorno(5, "Venerdi");
        result = PowerPreference.getDefaultFile().setObject("Venerdi", venerdi);
        Giorno sabato = new Giorno(6, "Sabato");
        result = PowerPreference.getDefaultFile().setObject("Sabato", sabato);
        Giorno domenica = new Giorno(7, "Domenica");
        result = PowerPreference.getDefaultFile().setObject("Domenica", domenica);
    }
}