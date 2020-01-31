package com.sviluppotrilo.trilo.controllers;

import android.util.Log;

import com.sviluppotrilo.trilo.domain.Giorno;
import com.sviluppotrilo.trilo.domain.RoutineSettimanale;
import com.sviluppotrilo.trilo.domain.Soluzione;

import java.util.Set;

public class PreferitiController {
    static final String ERRORE = "Errore: ";

    public Set<Soluzione> visualizzaPreferiti(int idGiorno){
        Set<Soluzione> preferiti = null;
        Giorno giorno;
        try {
            giorno = RoutineSettimanale.getGiorno(idGiorno);
            preferiti = giorno.getPreferiti();

        }catch(Exception e){
            Log.e(ERRORE, e.getMessage());
        }
        return preferiti;
    }

    public Set<Soluzione> visualizzaPreferitiOggi(){
        Set<Soluzione> preferiti = null;
        Giorno giorno;
        try {
            giorno = RoutineSettimanale.giornoAttuale();
            preferiti = giorno.getPreferiti();

        }catch(Exception e){
            Log.e(ERRORE, e.getMessage());
        }
        return preferiti;
    }

    public void eliminaPreferito(int idGiorno, Soluzione soluzione){
        Giorno giorno = null;
        try {
            giorno = RoutineSettimanale.getGiorno(idGiorno);
            giorno.rimuoviPreferito(soluzione);
        } catch (Exception e) {
            Log.e(ERRORE, e.getMessage());
        }
    }

    public void aggiungiPreferito(int idGiorno, Soluzione soluzione){
        Giorno giorno = null;
        try {
            giorno = RoutineSettimanale.getGiorno(idGiorno);
            giorno.aggiungiPreferito(soluzione);
        } catch (Exception e) {
            Log.e(ERRORE, e.getMessage());
        }
    }

    public void controllaPreferiti(){
        Giorno giorno = null;
        try {
            giorno = RoutineSettimanale.giornoAttuale();
            giorno.controllaSoluzioni();
        } catch (Exception e) {
            Log.e(ERRORE, e.getMessage());
        }
    }
}
