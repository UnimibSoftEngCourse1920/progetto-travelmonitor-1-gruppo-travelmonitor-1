package com.sviluppotrilo.trilo.Domain;

public class Soppresso implements CorsaState {
    public Soppresso(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        Notifica n = new NotificaSoppressione(corsa.getNumeroTreno());
        n.invia();
        return this;
    }
}
