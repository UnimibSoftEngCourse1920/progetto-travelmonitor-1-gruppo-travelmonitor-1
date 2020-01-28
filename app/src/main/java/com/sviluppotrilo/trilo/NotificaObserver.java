package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.CorsaState;
import com.sviluppotrilo.trilo.Domain.NonPartito;

import java.util.Observable;
import java.util.Observer;

public class NotificaObserver  implements Observer {
    Corsa corsa;
    CorsaState stato = new NonPartito();
    @Override
    public void update(Observable observable, Object corsa) {
        this.setCorsa((Corsa) corsa);
        stato = stato.statoCorsa((Corsa) corsa);
    }

    private void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }

}
