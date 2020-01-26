package com.sviluppotrilo.trilo.Domain;

public class ParzialmenteSoppresso implements CorsaState {

    @Override
    public CorsaState statoCorsa(Corsa corsa){
        Notifica n = new NotificaSoppressioneParziale(corsa);
        n.invia();
        return this;
    }
}
