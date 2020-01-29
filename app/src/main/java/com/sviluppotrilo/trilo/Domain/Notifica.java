package com.sviluppotrilo.trilo.Domain;

import android.app.Application;

public abstract class Notifica {
    String testoNotifica;

    public void invia(){
        System.out.println("sto inviando la notifica: " + testoNotifica);
    }
}
