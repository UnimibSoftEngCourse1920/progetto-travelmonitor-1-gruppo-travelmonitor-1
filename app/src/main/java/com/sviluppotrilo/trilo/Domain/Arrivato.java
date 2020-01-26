package com.sviluppotrilo.trilo.Domain;

public class Arrivato implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }



}
