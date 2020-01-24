package com.sviluppotrilo.trilo;

import android.util.Log;

public class Controller {
    public Viaggio cercaViaggio(Stazione partenza, Stazione arrivo, String data, String ora){
        Viaggio viaggio = null;
        try {
            viaggio = Viaggio.find(partenza, arrivo, data, ora);
        } catch(ViaggioException e){
            Log.e("Errore:", e.toString());
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
            Log.e("Errore:", e.toString());
        } catch (Exception e) {
            Log.e("Errore:", e.getMessage());
        }
        return corsa;
    }

}
