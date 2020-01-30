package com.sviluppotrilo.trilo.domain;

import com.preference.PowerPreference;
import com.sviluppotrilo.trilo.gui.PushNotification;

public abstract class Notifica {
    String testoNotifica;

    public void invia(){
        if(controllaPreferenze())
            PushNotification.invia(testoNotifica);
    }

    abstract boolean controllaPreferenze();
}
