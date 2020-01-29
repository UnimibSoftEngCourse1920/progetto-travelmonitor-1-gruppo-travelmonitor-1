package com.sviluppotrilo.trilo.gui;

import android.app.job.JobParameters;
import android.app.job.JobService;

import com.sviluppotrilo.trilo.controllers.PreferitiController;

public class Schedulatore extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        System.out.println("OK PARTITO");
        PreferitiController preferitiController = new PreferitiController();
        doBackgroundWork(preferitiController);
        return true;
    }
    private void doBackgroundWork(final PreferitiController preferitiController) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final int SECONDO = 1000;
                final int MINUTO = 60 * SECONDO;
                final int ORA = 60 * MINUTO;
                int periodoTempo = 10 * SECONDO;
                while(true){
                    try {
                        System.out.println("Controllo dei preferiti del giorno..");
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
