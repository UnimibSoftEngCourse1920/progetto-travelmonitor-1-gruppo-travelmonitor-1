package com.sviluppotrilo.trilo;

public class ParzialmenteSoppresso implements CorsaState {

    @Override
    public CorsaState statoCorsa(Corsa corsa){
        Notifica n = new NotificaSoppressioneParziale(corsa);
        n.invia();
        return this;
    }
}
