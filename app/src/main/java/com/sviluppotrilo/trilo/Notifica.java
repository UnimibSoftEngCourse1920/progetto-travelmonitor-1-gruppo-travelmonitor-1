package com.sviluppotrilo.trilo;

import java.util.Observable;
import java.util.Observer;

public class Notifica implements Observer {

    public Corsa corsa;

    @Override
    public void update(Observable o, Object corsa) {
        this.setCorsa((Corsa) corsa);
        System.out.println("La notifica ora controlla lo stato di corsa");
    }

    public Corsa getCorsa() {
        return corsa;
    }

    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }
}
