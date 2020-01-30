package com.sviluppotrilo.trilo.gui;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.sviluppotrilo.trilo.controllers.PreferitiController;

public class Schedulatore extends JobService {
    static final String TAG = "Scheduler";
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        PreferitiController preferitiController = new PreferitiController();
        doBackgroundWork(preferitiController);
        return true;
    }
    private void doBackgroundWork(final PreferitiController preferitiController) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                        Log.i(TAG, "Controllo dei preferiti del giorno");
                        preferitiController.controllaPreferiti();
            }
        }).start();
    }
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
