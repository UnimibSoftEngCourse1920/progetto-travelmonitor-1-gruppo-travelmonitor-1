package com.sviluppotrilo.trilo;

import android.util.Log;

public class PreferitiController {
    public Giorno visualizzaPreferiti(int idGiorno){
        Giorno giorno = null;
        try {
            giorno = RoutineSettimanale.getGiorno(idGiorno);
        }catch(Exception e){
            Log.e("Errore: ", e.getMessage());
        }
        return giorno;
    }

    public void eliminaPreferito(int idGiorno, Soluzione s){
        Giorno giorno = null;
        try {
            giorno = RoutineSettimanale.getGiorno(idGiorno);
            giorno.rimuoviPreferito(s);
        } catch (Exception e) {
            Log.e("Errore: ", e.getMessage());
        }
    }

    public void aggiungiPreferito(int idGiorno, Soluzione s){
        Giorno giorno = null;
        try {
            giorno = RoutineSettimanale.getGiorno(idGiorno);
            giorno.aggiungiPreferito(s);
        } catch (Exception e) {
            Log.e("Errore: ", e.getMessage());
        }
    }
}
