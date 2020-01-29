package com.sviluppotrilo.trilo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.icu.util.TimeUnit;
import android.text.format.Time;

import com.sviluppotrilo.trilo.Domain.Arrivato;
import com.sviluppotrilo.trilo.Domain.Giorno;
import com.sviluppotrilo.trilo.Domain.InOrario;
import com.sviluppotrilo.trilo.Domain.NonPartito;
import com.sviluppotrilo.trilo.Domain.RoutineSettimanale;
import com.sviluppotrilo.trilo.Domain.Soluzione;
import com.sviluppotrilo.trilo.Domain.Tratta;

import java.util.ArrayList;
import java.util.HashSet;

public class Schedulatore extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        System.out.println("OK PARTITO");
        HashSet<Soluzione> preferiti = new HashSet<>();
        try {
            preferiti = (HashSet<Soluzione>) RoutineSettimanale.giornoAttuale().getPreferiti();
        } catch (Exception e) {
            e.printStackTrace();
        }
        doBackgroundWork(preferiti);
        return true;
    }
    private void doBackgroundWork(final HashSet<Soluzione> preferiti) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final int SECONDO = 1000;
                final int MINUTO = 60 * SECONDO;
                final int ORA = 60 * MINUTO;
                int periodoTempo = 10 * SECONDO;
                while(true){
                    try {
                        System.out.println("PreferitiAggiornati" + preferiti);
                        for(Soluzione preferito: preferiti)
                            preferito.controllaTratte();
                            Thread.sleep(periodoTempo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ViaggioException e) {
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
