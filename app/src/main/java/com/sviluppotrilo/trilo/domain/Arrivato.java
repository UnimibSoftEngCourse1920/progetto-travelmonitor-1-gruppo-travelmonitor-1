package com.sviluppotrilo.trilo.domain;

public class Arrivato implements CorsaState {
    public Arrivato(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }



}
