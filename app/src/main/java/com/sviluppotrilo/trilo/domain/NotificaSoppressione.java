package com.sviluppotrilo.trilo.domain;

public class NotificaSoppressione extends Notifica{

    public NotificaSoppressione(int numeroTreno, String destinazione){
        testoNotifica = "Il treno " + numeroTreno + " diretto a "
                + destinazione + " è stato soppresso";
    }
}