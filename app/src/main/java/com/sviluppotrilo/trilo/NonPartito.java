package com.sviluppotrilo.trilo;

public class NonPartito implements CorsaState {

    @Override
    public CorsaState statoCorsa(Corsa corsa){
        if(corsa.isPartito() == true)
            return new InOrario().statoCorsa(corsa);
        if(corsa.isPartito() == false && corsa.getDescrizione()!=null) {
            Notifica n = new NotificaSoppressione(corsa.getNumeroTreno());
            n.invia();
            return new Soppresso().statoCorsa(corsa);
        }
        return this;
    }
}
