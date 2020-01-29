package com.sviluppotrilo.trilo.Domain;

public class NotificaSoppressioneParziale extends Notifica {

    public NotificaSoppressioneParziale(int numeroTreno, String destinazione, String descrizione){
        testoNotifica = "Il treno " + numeroTreno + "diretto a " + destinazione +
                "ha subito una soppressione parziale con la seguente descrizione: "
                + descrizione;
    }
}
