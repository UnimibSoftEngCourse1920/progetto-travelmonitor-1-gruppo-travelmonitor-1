package com.sviluppotrilo.trilo.Controller;

import android.util.Log;

import com.sviluppotrilo.trilo.Domain.Giorno;
import com.sviluppotrilo.trilo.Domain.RoutineSettimanale;
import com.sviluppotrilo.trilo.Domain.Soluzione;

import java.util.Set;

public class PreferitiController {
    public Set<Soluzione> visualizzaPreferiti(int idGiorno){
        Set<Soluzione> preferiti = null;
        Giorno giorno;
        try {
            giorno = RoutineSettimanale.getGiorno(idGiorno);
            preferiti = giorno.getPreferiti();

        }catch(Exception e){
            Log.e("Errore: ", e.getMessage());
        }
        return preferiti;
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
