package com.sviluppotrilo.trilo;

public abstract class Notifica {
    String testoNotifica;

    public void invia(){
        System.out.println("sto inviando la notifica" + testoNotifica);
    }
}
