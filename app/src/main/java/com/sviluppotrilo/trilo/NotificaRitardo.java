package com.sviluppotrilo.trilo;

public class NotificaRitardo extends Notifica {

    public NotificaRitardo(int ritardo, int numeroTreno){
        testoNotifica = "Il treno" + numeroTreno + "ha guadagnato " + ritardo +
                " minuti di ritardo";
    }
}
