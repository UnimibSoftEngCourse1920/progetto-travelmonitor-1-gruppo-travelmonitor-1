package com.sviluppotrilo.trilo.domain;

import com.preference.PowerPreference;

public class NotificaRitardo extends Notifica {

    public NotificaRitardo(int ritardo, int numeroTreno, String destinazione){
        testoNotifica = "Il treno " + numeroTreno + " diretto a "
                + destinazione + " ha guadagnato " + ritardo + " minuti di ritardo";
    }

    @Override
    public boolean controllaPreferenze(){
        System.out.println(PowerPreference.getFileByName("impostazioni").getBoolean("notificaRitardo"));
        return PowerPreference.getFileByName("impostazioni").getBoolean("notificaRitardo");
    }
}
