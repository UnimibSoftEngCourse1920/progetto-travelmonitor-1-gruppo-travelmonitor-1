package com.sviluppotrilo.trilo.domain;

import com.sviluppotrilo.trilo.domain.Corsa;
import com.sviluppotrilo.trilo.domain.CorsaState;
import com.sviluppotrilo.trilo.domain.NonPartito;

import java.util.Observable;
import java.util.Observer;

public class NotificaObserver  implements Observer {
    CorsaState stato;

    public NotificaObserver() {
        stato = new NonPartito();
    }

    @Override
    public void update(Observable observable, Object corsa) {
        stato = stato.statoCorsa((Corsa) corsa);
    }
}
