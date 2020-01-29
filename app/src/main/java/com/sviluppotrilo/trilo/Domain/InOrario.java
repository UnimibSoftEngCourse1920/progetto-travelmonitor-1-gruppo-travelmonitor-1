package com.sviluppotrilo.trilo.Domain;

public class InOrario implements CorsaState {
    public InOrario(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        System.out.println(this.getClass());
        new NotificaRitardo(2,2).invia();
        if(corsa.getStazioneUltimoRilevamento().equals(corsa.getDestinazione()))
            return new Arrivato().statoCorsa(corsa);
        if(corsa.getProvvedimento() == 1 && corsa.getTipoTreno().equals("ST")) {
            new NotificaSoppressione(corsa.getNumeroTreno());
            return new Soppresso().statoCorsa(corsa);
        }
        Stazione sur = corsa.getStazioneUltimoRilevamento();
        for(Fermata fermata : corsa.getFermate())
            if(fermata.getStazione().getNome().equals(sur.getNome()) && fermata.getRitardo() >= 5) {
                new NotificaRitardo(fermata.getRitardo(), corsa.getNumeroTreno()).invia();
                return new InRitardo().statoCorsa(corsa);
            }
        return this;
    }
}