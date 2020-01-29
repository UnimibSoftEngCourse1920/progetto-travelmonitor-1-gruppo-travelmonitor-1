package com.sviluppotrilo.trilo.Domain;

public class NotificaRitardo extends Notifica {

    public NotificaRitardo(int ritardo, int numeroTreno, String destinazione){
        testoNotifica = "Il treno " + numeroTreno + " diretto a "
                + destinazione + " ha guadagnato " + ritardo + " minuti di ritardo";
    }
}
