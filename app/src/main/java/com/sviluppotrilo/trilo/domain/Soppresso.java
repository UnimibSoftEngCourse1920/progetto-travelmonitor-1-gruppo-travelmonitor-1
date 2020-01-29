package com.sviluppotrilo.trilo.domain;

public class Soppresso implements CorsaState {
    public Soppresso(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }
}
