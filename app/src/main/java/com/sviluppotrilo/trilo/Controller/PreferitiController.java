package com.sviluppotrilo.trilo.Controller;

import android.util.Log;

import com.sviluppotrilo.trilo.Domain.Giorno;
import com.sviluppotrilo.trilo.Domain.RoutineSettimanale;
import com.sviluppotrilo.trilo.Domain.Soluzione;

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

    public void controllaPreferiti(){
        try {
            RoutineSettimanale.giornoAttuale().controllaSoluzioni();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
