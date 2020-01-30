package com.sviluppotrilo.trilo.domain;

import java.util.Observable;
import java.util.Observer;

public class NotificaObserver  implements Observer {
    CorsaState stato;

    public NotificaObserver() {
        stato = new Regolare();
    }

    @Override
    public void update(Observable observable, Object corsa) {
        stato = stato.statoCorsa((Corsa) corsa);
    }
}
