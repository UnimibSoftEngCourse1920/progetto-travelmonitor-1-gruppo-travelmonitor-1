package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.CorsaState;
import com.sviluppotrilo.trilo.Domain.NonPartito;

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
