package com.sviluppotrilo.trilo.Controller;

import android.util.Log;

import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Viaggio;
import com.sviluppotrilo.trilo.ViaggioException;

public class ViaggioController {
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
}
