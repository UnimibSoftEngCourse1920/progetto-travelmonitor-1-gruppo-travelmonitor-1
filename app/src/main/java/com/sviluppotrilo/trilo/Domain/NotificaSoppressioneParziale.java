package com.sviluppotrilo.trilo.Domain;

public class NotificaSoppressioneParziale extends Notifica {

    public NotificaSoppressioneParziale(Corsa corsa){
        testoNotifica = corsa.getNumeroTreno() + ": " + corsa.getDescrizione();
    }
}
