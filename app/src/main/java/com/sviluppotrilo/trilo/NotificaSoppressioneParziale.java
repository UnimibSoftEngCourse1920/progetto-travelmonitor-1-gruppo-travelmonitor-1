package com.sviluppotrilo.trilo;

public class NotificaSoppressioneParziale extends Notifica {

    public NotificaSoppressioneParziale(Corsa corsa){
        testoNotifica = corsa.getDescrizione();
    }
}
