package com.sviluppotrilo.trilo.Domain;

public class ParzialmenteSoppresso implements CorsaState {
    public ParzialmenteSoppresso(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa){
        if(corsa.isPartito() == true)
            return new InOrario().statoCorsa(corsa);
        if(corsa.getProvvedimento() == 1 && corsa.getTipoTreno().equals("ST")) {
            new NotificaSoppressione(corsa.getNumeroTreno(), corsa.getDestinazione().getNome()).invia();
            return new Soppresso().statoCorsa(corsa);
        }
        return this;
    }
}
