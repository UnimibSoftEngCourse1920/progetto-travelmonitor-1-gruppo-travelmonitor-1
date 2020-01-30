package com.sviluppotrilo.trilo.domain;

public class ParzialmenteSoppresso implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa){
        if(corsa.isPartito())
            return new InOrario().statoCorsa(corsa);
        if(corsa.getProvvedimento() == 1 && corsa.getTipoTreno().equals("ST")) {
            new NotificaSoppressione(corsa.getNumeroTreno(), corsa.getDestinazione().getNome()).invia();
            return new Soppresso().statoCorsa(corsa);
        }
        return this;
    }
}
