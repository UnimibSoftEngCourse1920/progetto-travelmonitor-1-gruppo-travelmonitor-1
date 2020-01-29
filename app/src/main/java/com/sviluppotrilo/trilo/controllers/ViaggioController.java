package com.sviluppotrilo.trilo.controllers;

import android.util.Log;

import com.sviluppotrilo.trilo.domain.Arrivi;
import com.sviluppotrilo.trilo.domain.Corsa;
import com.sviluppotrilo.trilo.domain.Partenze;
import com.sviluppotrilo.trilo.domain.Stazione;
import com.sviluppotrilo.trilo.domain.Viaggio;
import com.sviluppotrilo.trilo.domain.ViaggioException;


public class ViaggioController {
    final static String ERRORE = "Errore: ";

    public Viaggio cercaViaggio(Stazione partenza, Stazione arrivo, String data, String ora){
        Viaggio viaggio = null;
        try {
            viaggio = Viaggio.find(partenza, arrivo, data, ora);
        } catch(ViaggioException e){
            Log.e(ERRORE, e.getMessage());
        } catch (Exception e) {
            Log.e(ERRORE, e.getMessage());
        }
        return viaggio;
    }

    public Corsa cercaCorsa(Stazione partenza, String numeroTreno){
        Corsa corsa = null;
        try {
            corsa = Corsa.find(partenza, numeroTreno);
        } catch(ViaggioException e){
            Log.e(ERRORE, e.getMessage());
        } catch (Exception e) {
            Log.e(ERRORE, e.getMessage());
        }
        return corsa;
    }
}
