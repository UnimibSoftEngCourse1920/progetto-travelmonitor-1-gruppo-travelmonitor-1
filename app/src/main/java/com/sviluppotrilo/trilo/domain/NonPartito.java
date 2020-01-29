package com.sviluppotrilo.trilo.domain;

public class NonPartito implements CorsaState {
    public NonPartito(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa){
        System.out.println(this.getClass());
        if((corsa.getProvvedimento() == 0 || corsa.getProvvedimento() == 2) && (corsa.getTipoTreno().equals("PP") ||
                corsa.getTipoTreno().equals("SI") || corsa.getTipoTreno().equals("SF"))){
            new NotificaSoppressioneParziale(corsa.getNumeroTreno(), corsa.getDestinazione().getNome(), corsa.getDescrizione()).invia();
            return new ParzialmenteSoppresso().statoCorsa(corsa);
        }
        if(corsa.isPartito())
            return new InOrario().statoCorsa(corsa);
        if(corsa.getProvvedimento() == 1 && corsa.getTipoTreno().equals("ST")) {
            new NotificaSoppressione(corsa.getNumeroTreno(), corsa.getDestinazione().getNome()).invia();
            return new Soppresso().statoCorsa(corsa);
        }
        return this;
    }
}