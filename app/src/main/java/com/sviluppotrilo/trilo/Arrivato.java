package com.sviluppotrilo.trilo;

public class Arrivato implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }



}
