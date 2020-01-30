package com.sviluppotrilo.trilo.gui;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.sviluppotrilo.trilo.controllers.PreferitiController;

public class Schedulatore extends JobService {
    static final String INFO = "Scheduler";
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
                int periodoTempo = 10 * 1000;
                while(true){
                    try {
                        Log.i(INFO, "Controllo dei preferiti del giorno");
                        preferitiController.controllaPreferiti();
                        Thread.sleep(periodoTempo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
