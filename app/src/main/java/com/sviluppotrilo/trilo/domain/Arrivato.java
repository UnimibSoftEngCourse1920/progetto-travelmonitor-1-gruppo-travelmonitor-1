package com.sviluppotrilo.trilo.domain;

public class Arrivato implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }
}
