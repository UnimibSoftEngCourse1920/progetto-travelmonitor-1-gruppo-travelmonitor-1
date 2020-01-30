package com.sviluppotrilo.trilo.domain;

import com.preference.PowerPreference;

public class NotificaSoppressioneParziale extends Notifica {

    public NotificaSoppressioneParziale(int numeroTreno, String destinazione, String descrizione){
        testoNotifica = "Il treno " + numeroTreno + "diretto a " + destinazione +
                "ha subito una soppressione parziale con la seguente descrizione: "
                + descrizione;
    }

    @Override
    public boolean controllaPreferenze(){
        return PowerPreference.getFileByName("impostazioni").getBoolean("notificaCancellazione");
    }
}
