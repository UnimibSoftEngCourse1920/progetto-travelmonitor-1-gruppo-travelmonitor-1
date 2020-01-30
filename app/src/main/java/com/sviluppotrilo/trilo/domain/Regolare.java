package com.sviluppotrilo.trilo.domain;

public class Regolare implements CorsaState {

    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        if((corsa.getProvvedimento() == 0 || corsa.getProvvedimento() == 2) && (corsa.getTipoTreno().equals("PP") ||
                corsa.getTipoTreno().equals("SI") || corsa.getTipoTreno().equals("SF"))){
            new NotificaSoppressioneParziale(corsa.getNumeroTreno(), corsa.getDestinazione().getNome(), corsa.getDescrizione()).invia();
            return new ParzialmenteSoppresso().statoCorsa(corsa);
        }
        if(corsa.getStazioneUltimoRilevamento().equals(corsa.getDestinazione()))
            return new Arrivato().statoCorsa(corsa);
        if(corsa.getProvvedimento() == 1 && corsa.getTipoTreno().equals("ST")) {
            new NotificaSoppressione(corsa.getNumeroTreno(), corsa.getDestinazione().getNome()).invia();
            return new Soppresso().statoCorsa(corsa);
        }
        Stazione sur = corsa.getStazioneUltimoRilevamento();
        for(Fermata fermata : corsa.getFermate())
            if(fermata.getStazione().getNome().equals(sur.getNome()) && fermata.getRitardo() >= 5) {
                new NotificaRitardo(fermata.getRitardo(), corsa.getNumeroTreno(), corsa.getDestinazione().getNome()).invia();
                return new InRitardo().statoCorsa(corsa);
            }
        return this;
    }
}