package com.sviluppotrilo.trilo.domain;

import com.preference.PowerPreference;

public class NotificaSoppressione extends Notifica{

    public NotificaSoppressione(int numeroTreno, String destinazione){
        testoNotifica = "Il treno " + numeroTreno + " diretto a "
                + destinazione + " è stato soppresso";
    }

    @Override
    public boolean controllaPreferenze(){
        return PowerPreference.getFileByName("impostazioni").getBoolean("notificaCancellazione");
    }
}
