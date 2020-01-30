package com.sviluppotrilo.trilo.domain;

public class Soppresso implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }
}
