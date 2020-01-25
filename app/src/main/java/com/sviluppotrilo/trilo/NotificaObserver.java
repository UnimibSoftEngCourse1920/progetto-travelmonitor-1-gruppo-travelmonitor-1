package com.sviluppotrilo.trilo;

import java.util.Observable;
import java.util.Observer;

public class NotificaObserver implements Observer {

    private CorsaState stato;

    private Corsa corsa;

    public NotificaObserver(){
        stato = new NonPartito();
    }

    @Override
    public void update(Observable o, Object corsa) {
        setCorsa((Corsa) corsa);
        stato = stato.statoCorsa((Corsa) corsa);
    }

    public Corsa getCorsa() {
        return corsa;
    }

    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }

}
