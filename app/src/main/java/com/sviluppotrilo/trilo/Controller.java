package com.sviluppotrilo.trilo;

import android.util.Log;

public class Controller {
    public Viaggio cercaViaggio(Stazione partenza, Stazione arrivo, String data, String ora){
        Viaggio viaggio = null;
        try {
            viaggio = Viaggio.find(partenza, arrivo, data, ora);
        } catch (Exception e) {
            Log.e("Errore:", e.toString());
        }
        return viaggio;
    }
}
