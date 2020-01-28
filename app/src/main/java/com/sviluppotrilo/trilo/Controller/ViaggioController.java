package com.sviluppotrilo.trilo.Controller;

import android.util.Log;

import com.sviluppotrilo.trilo.Domain.Arrivi;
import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.Partenze;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Viaggio;
import com.sviluppotrilo.trilo.ViaggioException;


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

    public Arrivi[] cercaTabelloneArrivi(Stazione stazione){
        Arrivi[] arrivi = null;
        try {
            arrivi = Arrivi.find(stazione);
        } catch (Exception e) {
            Log.e(ERRORE, e.getMessage());
        }
        return arrivi;
    }

    public Partenze[] cercaTabellonePartenze(Stazione stazione){
        Partenze[] partenze = null;
        try {
            partenze = Partenze.find(stazione);
        } catch (Exception e) {
            Log.e(ERRORE, e.getMessage());
        }
        return partenze;
    }
}
