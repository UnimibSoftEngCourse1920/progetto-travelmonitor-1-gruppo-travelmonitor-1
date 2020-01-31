package com.sviluppotrilo.trilo.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Soluzione {
    private List<Tratta> tratte;
    private String durata;

    public Soluzione() {
        tratte = new ArrayList<>();
    }

    public String getDurata() {
        return durata;
    }
    public void setDurata(String durata) {
        this.durata = durata;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    public int numeroCambi() {
        return tratte.size() - 1;
    }

    @Override
    public String toString() {
        return "Soluzione [tratte=" + tratte + ", durata=" + durata + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soluzione)) return false;
        Soluzione soluzione = (Soluzione) o;
        return Objects.equals(getTratte(), soluzione.getTratte()) &&
                Objects.equals(getDurata(), soluzione.getDurata());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTratte(), getDurata());
    }

    public void controllaTratte() {
        for (final Tratta t: getTratte()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        CorsaState stato;
                        while(true) {
                            t.update();
                            stato = t.getStato();
                            if(notificato(stato))
                                break;
                            Log.i("INFO", "AGGIORNAMENTO: " + t + "con stato" + stato);
                            Thread.sleep(1_000L * 60 * 5);
                        }
                    } catch (ViaggioException e) {
                        Log.i("INFO: ", e.getMessage());
                    } catch (InterruptedException e) {
                        Log.i("INFO", e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }

    private boolean notificato(CorsaState stato){
        if(stato instanceof Arrivato ||
                stato instanceof Soppresso ||
                stato instanceof ParzialmenteSoppresso) {
            return true;
        }
        return false;
    }
}
