package com.sviluppotrilo.trilo;

public class Soppresso implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        return this;
    }
}
