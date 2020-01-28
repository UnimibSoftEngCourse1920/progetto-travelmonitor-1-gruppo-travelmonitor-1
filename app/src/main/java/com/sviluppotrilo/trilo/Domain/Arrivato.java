package com.sviluppotrilo.trilo.Domain;

public class Arrivato implements CorsaState {
    public Arrivato(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }



}
