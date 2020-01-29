package com.sviluppotrilo.trilo.domain;

import com.sviluppotrilo.trilo.gui.PushNotification;

public abstract class Notifica {
    String testoNotifica;

    public void invia(){
        PushNotification.invia(testoNotifica);
    }
}
