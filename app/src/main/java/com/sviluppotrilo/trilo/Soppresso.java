package com.sviluppotrilo.trilo;

public class Soppresso implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        Notifica n = new NotificaSoppressione(corsa.getNumeroTreno());
        n.invia();
        return this;
    }
}
