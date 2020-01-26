package com.sviluppotrilo.trilo;

import android.util.Log;

public class Controller {
    public Viaggio cercaViaggio(Stazione partenza, Stazione arrivo, String data, String ora){
        Viaggio viaggio = null;
        try {
            viaggio = Viaggio.find(partenza, arrivo, data, ora);
        } catch(ViaggioException e){
            Log.e("Errore:", e.getMessage());
        } catch (Exception e) {
            Log.e("Errore:", e.getMessage());
        }
        return viaggio;
    }

    public Corsa cercaCorsa(Stazione partenza, String numeroTreno){
        Corsa corsa = null;
        try {
            corsa = Corsa.find(partenza, numeroTreno);
        } catch(ViaggioException e){
            Log.e("Errore:", e.getMessage());
        } catch (Exception e) {
            Log.e("Errore:", e.getMessage());
        }
        return corsa;
    }

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
